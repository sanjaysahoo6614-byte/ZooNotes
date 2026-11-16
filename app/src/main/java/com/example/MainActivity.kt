package com.example

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmarks
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.outlined.Bookmarks
import androidx.compose.material.icons.outlined.School
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.data.local.ZooNotesDatabase
import com.example.data.local.ZooNotesRepository
import com.example.ui.components.DiagramZoomViewerScreen
import com.example.ui.screens.BookmarksScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.PaperDetailScreen
import com.example.ui.theme.ZooNotesTheme
import com.example.ui.viewmodel.ZoologyViewModel

const val ROUTE_HOME = "home"
const val ROUTE_BOOKMARKS = "bookmarks"
const val ROUTE_PAPER = "paper/{paperId}?tab={tab}&unitId={unitId}"
const val ROUTE_DIAGRAM_VIEWER = "diagram/{diagramId}"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val db = ZooNotesDatabase.getInstance(applicationContext)
        val repository = ZooNotesRepository(db.bookmarkDao(), db.quizAttemptDao())

        setContent {
            ZooNotesTheme {
                val vm: ZoologyViewModel = viewModel(factory = ZoologyViewModel.Factory(repository))
                ZooNotesApp(viewModel = vm)
            }
        }
    }
}

@Composable
fun ZooNotesApp(viewModel: ZoologyViewModel) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val homeUiState by viewModel.homeUiState.collectAsStateWithLifecycle()
    val bookmarks by viewModel.bookmarks.collectAsStateWithLifecycle()
    val bookmarkedIds by viewModel.bookmarkedIds.collectAsStateWithLifecycle()
    val bookmarkFilter by viewModel.bookmarkFilter.collectAsStateWithLifecycle()
    val quizAttempts by viewModel.quizAttempts.collectAsStateWithLifecycle()

    val showBottomBar = currentRoute == ROUTE_HOME || currentRoute == ROUTE_BOOKMARKS

    Scaffold(
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        bottomBar = {
            if (showBottomBar) {
                NavigationBar(
                    containerColor = MaterialTheme.colorScheme.surface,
                    contentColor = MaterialTheme.colorScheme.primary
                ) {
                    NavigationBarItem(
                        selected = currentRoute == ROUTE_HOME,
                        onClick = {
                            navController.navigate(ROUTE_HOME) {
                                popUpTo(ROUTE_HOME) { inclusive = false }
                                launchSingleTop = true
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = if (currentRoute == ROUTE_HOME) Icons.Filled.School else Icons.Outlined.School,
                                contentDescription = stringResource(R.string.nav_curriculum)
                            )
                        },
                        label = { Text(stringResource(R.string.nav_curriculum)) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.primary,
                            selectedTextColor = MaterialTheme.colorScheme.primary,
                            indicatorColor = MaterialTheme.colorScheme.primaryContainer
                        ),
                        modifier = Modifier.testTag("nav_semesters")
                    )

                    NavigationBarItem(
                        selected = currentRoute == ROUTE_BOOKMARKS,
                        onClick = {
                            navController.navigate(ROUTE_BOOKMARKS) {
                                popUpTo(ROUTE_HOME) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            BadgedBox(
                                badge = {
                                    if (bookmarks.isNotEmpty()) {
                                        Badge { Text(bookmarks.size.toString()) }
                                    }
                                }
                            ) {
                                Icon(
                                    imageVector = if (currentRoute == ROUTE_BOOKMARKS) Icons.Filled.Bookmarks else Icons.Outlined.Bookmarks,
                                    contentDescription = stringResource(R.string.nav_bookmarks)
                                )
                            }
                        },
                        label = { Text(stringResource(R.string.nav_bookmarks)) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.primary,
                            selectedTextColor = MaterialTheme.colorScheme.primary,
                            indicatorColor = MaterialTheme.colorScheme.primaryContainer
                        ),
                        modifier = Modifier.testTag("nav_bookmarks")
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = ROUTE_HOME,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable(ROUTE_HOME) {
                HomeScreen(
                    uiState = homeUiState,
                    onSearchQueryChange = viewModel::onSearchQueryChange,
                    onSelectSemesterFilter = viewModel::onSelectSemesterFilter,
                    onOpenPaper = { paperId, tab, unitId ->
                        val encodedUnit = Uri.encode(unitId ?: "")
                        navController.navigate("paper/$paperId?tab=$tab&unitId=$encodedUnit")
                    },
                    onOpenDiagram = { diagramId ->
                        navController.navigate("diagram/$diagramId")
                    }
                )
            }

            composable(ROUTE_BOOKMARKS) {
                BookmarksScreen(
                    bookmarks = bookmarks,
                    selectedFilter = bookmarkFilter,
                    onSelectFilter = viewModel::onSelectBookmarkFilter,
                    onOpenNote = { paperId, unitId ->
                        navController.navigate("paper/$paperId?tab=0&unitId=${Uri.encode(unitId)}")
                    },
                    onOpenDiagram = { diagramId ->
                        navController.navigate("diagram/$diagramId")
                    },
                    onRemoveBookmark = viewModel::removeBookmark
                )
            }

            composable(
                route = ROUTE_PAPER,
                arguments = listOf(
                    navArgument("paperId") { type = NavType.StringType },
                    navArgument("tab") { type = NavType.IntType; defaultValue = 0 },
                    navArgument("unitId") { type = NavType.StringType; defaultValue = "" }
                )
            ) { entry ->
                val paperId = entry.arguments?.getString("paperId").orEmpty()
                val tab = entry.arguments?.getInt("tab") ?: 0
                val unitId = entry.arguments?.getString("unitId").takeUnless { it.isNullOrBlank() }
                val paper = viewModel.getPaperById(paperId)

                if (paper == null) {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text("Paper not found")
                    }
                } else {
                    PaperDetailScreen(
                        paper = paper,
                        initialTabIndex = tab,
                        highlightedUnitId = unitId,
                        bookmarkedIds = bookmarkedIds,
                        quizAttempts = quizAttempts,
                        onToggleNoteBookmark = { unit -> viewModel.toggleNoteBookmark(paper, unit) },
                        onToggleDiagramBookmark = { diag -> viewModel.toggleDiagramBookmark(paper, diag) },
                        onToggleBookBookmark = { book -> viewModel.toggleBookBookmark(paper, book) },
                        onOpenDiagramViewer = { diagramId ->
                            navController.navigate("diagram/$diagramId")
                        },
                        onRecordQuizScore = viewModel::recordQuizAttempt,
                        onBack = { navController.popBackStack() }
                    )
                }
            }

            composable(
                route = ROUTE_DIAGRAM_VIEWER,
                arguments = listOf(
                    navArgument("diagramId") { type = NavType.StringType }
                )
            ) { entry ->
                val diagramId = entry.arguments?.getString("diagramId").orEmpty()
                val match = viewModel.getDiagramById(diagramId)

                if (match == null) {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text("Diagram not found")
                    }
                } else {
                    val (paper, diagram) = match
                    DiagramZoomViewerScreen(
                        paperTitle = paper.title,
                        diagram = diagram,
                        isBookmarked = bookmarkedIds.contains(diagram.id),
                        onToggleBookmark = { viewModel.toggleDiagramBookmark(paper, diagram) },
                        onBack = { navController.popBackStack() }
                    )
                }
            }
        }
    }
}
