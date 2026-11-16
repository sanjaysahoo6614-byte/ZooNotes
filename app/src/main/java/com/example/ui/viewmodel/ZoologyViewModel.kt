package com.example.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.data.local.BookmarkEntity
import com.example.data.local.BookmarkType
import com.example.data.local.QuizAttemptEntity
import com.example.data.local.ZooNotesRepository
import com.example.data.model.BiologicalDiagram
import com.example.data.model.ReferenceBook
import com.example.data.model.SearchHit
import com.example.data.model.SemesterInfo
import com.example.data.model.StudyUnit
import com.example.data.model.ZoologyPaper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class HomeUiState(
    val semesters: List<SemesterInfo> = emptyList(),
    val selectedSemesterFilter: Int? = null,
    val searchQuery: String = "",
    val searchHits: List<SearchHit> = emptyList(),
    val bookmarkCount: Int = 0
)

class ZoologyViewModel(
    private val repository: ZooNotesRepository
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _selectedSemesterFilter = MutableStateFlow<Int?>(null)
    val selectedSemesterFilter: StateFlow<Int?> = _selectedSemesterFilter.asStateFlow()

    private val _bookmarkFilter = MutableStateFlow<BookmarkType?>(null)
    val bookmarkFilter: StateFlow<BookmarkType?> = _bookmarkFilter.asStateFlow()

    val bookmarks: StateFlow<List<BookmarkEntity>> = repository.allBookmarks
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val bookmarkedIds: StateFlow<Set<String>> = repository.bookmarkedIds
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptySet())

    val quizAttempts: StateFlow<Map<String, QuizAttemptEntity>> = repository.quizAttemptsByChapter
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyMap())

    val homeUiState: StateFlow<HomeUiState> = combine(
        _searchQuery,
        _selectedSemesterFilter,
        bookmarks
    ) { query, semFilter, savedBookmarks ->
        val filteredSemesters = if (semFilter == null) {
            repository.semesters
        } else {
            repository.semesters.filter { it.semesterNumber == semFilter }
        }
        HomeUiState(
            semesters = filteredSemesters,
            selectedSemesterFilter = semFilter,
            searchQuery = query,
            searchHits = repository.search(query),
            bookmarkCount = savedBookmarks.size
        )
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        HomeUiState(semesters = repository.semesters)
    )

    fun onSearchQueryChange(newQuery: String) {
        _searchQuery.value = newQuery
    }

    fun onSelectSemesterFilter(semesterNumber: Int?) {
        _selectedSemesterFilter.value = semesterNumber
    }

    fun onSelectBookmarkFilter(type: BookmarkType?) {
        _bookmarkFilter.value = type
    }

    fun getPaperById(paperId: String): ZoologyPaper? = repository.getPaperById(paperId)

    fun getDiagramById(diagramId: String): Pair<ZoologyPaper, BiologicalDiagram>? =
        repository.getDiagramById(diagramId)

    fun toggleNoteBookmark(paper: ZoologyPaper, unit: StudyUnit) {
        viewModelScope.launch {
            val isSaved = bookmarkedIds.value.contains(unit.id)
            repository.toggleNoteBookmark(paper, unit, isSaved)
        }
    }

    fun toggleDiagramBookmark(paper: ZoologyPaper, diagram: BiologicalDiagram) {
        viewModelScope.launch {
            val isSaved = bookmarkedIds.value.contains(diagram.id)
            repository.toggleDiagramBookmark(paper, diagram, isSaved)
        }
    }

    fun toggleBookBookmark(paper: ZoologyPaper, book: ReferenceBook) {
        viewModelScope.launch {
            val isSaved = bookmarkedIds.value.contains(book.id)
            repository.toggleBookBookmark(paper, book, isSaved)
        }
    }

    fun removeBookmark(itemId: String) {
        viewModelScope.launch {
            repository.removeBookmark(itemId)
        }
    }

    fun recordQuizAttempt(chapterId: String, score: Int, totalQuestions: Int) {
        viewModelScope.launch {
            repository.recordQuizAttempt(chapterId, score, totalQuestions)
        }
    }

    class Factory(private val repository: ZooNotesRepository) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ZoologyViewModel(repository) as T
        }
    }
}
