package com.example.ui.screens

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.data.local.QuizAttemptEntity
import com.example.data.model.BiologicalDiagram
import com.example.data.model.ReferenceBook
import com.example.data.model.StudyUnit
import com.example.data.model.ZoologyPaper
import com.example.ui.components.DiagramGalleryCard
import com.example.ui.components.InteractiveQuizCard
import com.example.ui.components.PyqCard
import com.example.ui.components.ReferenceBookCard
import com.example.ui.components.StudyUnitCard
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaperDetailScreen(
    paper: ZoologyPaper,
    initialTabIndex: Int,
    highlightedUnitId: String?,
    bookmarkedIds: Set<String>,
    quizAttempts: Map<String, QuizAttemptEntity>,
    onToggleNoteBookmark: (StudyUnit) -> Unit,
    onToggleDiagramBookmark: (BiologicalDiagram) -> Unit,
    onToggleBookBookmark: (ReferenceBook) -> Unit,
    onOpenDiagramViewer: (diagramId: String) -> Unit,
    onRecordQuizScore: (chapterId: String, score: Int, total: Int) -> Unit,
    onBack: () -> Unit
) {
    var selectedTab by remember(paper.id, initialTabIndex) {
        mutableIntStateOf(initialTabIndex.coerceIn(0, 3))
    }
    val tabTitles = listOf("Study Notes", "Diagrams", "Reference Books", "PYQs & Quizzes")
    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    // Segment inside PYQs & Quizzes tab (0 = All, 1 = PYQs, 2 = Quizzes)
    var assessmentSegment by remember(paper.id) { mutableIntStateOf(0) }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Sem ${paper.semester} • ${paper.code}",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = paper.title,
                            style = MaterialTheme.typography.titleMedium,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBack,
                        modifier = Modifier.testTag("paper_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back to Semesters"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.background)
        ) {
            ScrollableTabRow(
                selectedTabIndex = selectedTab,
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.primary,
                edgePadding = 12.dp
            ) {
                tabTitles.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTab == index,
                        onClick = { selectedTab = index },
                        text = { Text(text = title, style = MaterialTheme.typography.labelLarge) },
                        modifier = Modifier.testTag("paper_tab_$index")
                    )
                }
            }

            when (selectedTab) {
                // 1. Study Notes Tab
                0 -> {
                    LazyColumn(
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        itemsIndexed(paper.units, key = { _, u -> u.id }) { idx, unit ->
                            val shouldExpand = if (highlightedUnitId != null) {
                                unit.id == highlightedUnitId
                            } else {
                                idx == 0
                            }
                            StudyUnitCard(
                                unit = unit,
                                isBookmarked = bookmarkedIds.contains(unit.id),
                                initiallyExpanded = shouldExpand,
                                onToggleBookmark = { onToggleNoteBookmark(unit) }
                            )
                        }
                    }
                }

                // 2. Diagrams Tab
                1 -> {
                    LazyColumn(
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(14.dp),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(paper.diagrams, key = { it.id }) { diagram ->
                            DiagramGalleryCard(
                                diagram = diagram,
                                isBookmarked = bookmarkedIds.contains(diagram.id),
                                onToggleBookmark = { onToggleDiagramBookmark(diagram) },
                                onOpenZoomViewer = { onOpenDiagramViewer(diagram.id) }
                            )
                        }
                    }
                }

                // 3. Reference Books Tab
                2 -> {
                    LazyColumn(
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(paper.books, key = { it.id }) { book ->
                            ReferenceBookCard(
                                book = book,
                                isBookmarked = bookmarkedIds.contains(book.id),
                                onOpenPdf = {
                                    try {
                                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(book.pdfUrl))
                                        context.startActivity(intent)
                                    } catch (_: ActivityNotFoundException) {
                                        coroutineScope.launch {
                                            snackbarHostState.showSnackbar("No browser or PDF viewer found to open link.")
                                        }
                                    }
                                },
                                onToggleBookmark = { onToggleBookBookmark(book) }
                            )
                        }
                    }
                }

                // 4. PYQs & Quizzes Tab
                3 -> {
                    LazyColumn(
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        item {
                            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                listOf("All", "PYQs (${paper.pyqs.size})", "MCQ Quizzes (${paper.quizChapters.size})").forEachIndexed { idx, label ->
                                    FilterChip(
                                        selected = assessmentSegment == idx,
                                        onClick = { assessmentSegment = idx },
                                        label = { Text(label) },
                                        colors = FilterChipDefaults.filterChipColors(
                                            selectedContainerColor = MaterialTheme.colorScheme.primary,
                                            selectedLabelColor = Color.White
                                        )
                                    )
                                }
                            }
                        }

                        if (assessmentSegment == 0 || assessmentSegment == 1) {
                            item {
                                Text(
                                    text = "Previous Year Short-Answer Questions",
                                    style = MaterialTheme.typography.titleMedium,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                            items(paper.pyqs, key = { it.id }) { pyq ->
                                PyqCard(pyq = pyq)
                            }
                        }

                        if (assessmentSegment == 0 || assessmentSegment == 2) {
                            item {
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "Chapter-Wise Practice Quizzes",
                                    style = MaterialTheme.typography.titleMedium,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                            items(paper.quizChapters, key = { it.id }) { chapter ->
                                InteractiveQuizCard(
                                    chapter = chapter,
                                    bestAttempt = quizAttempts[chapter.id],
                                    onQuizCompleted = { score, total ->
                                        onRecordQuizScore(chapter.id, score, total)
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
