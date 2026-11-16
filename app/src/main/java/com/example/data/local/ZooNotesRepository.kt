package com.example.data.local

import com.example.data.curriculum.ZoologyCurriculumRepository
import com.example.data.model.BiologicalDiagram
import com.example.data.model.ReferenceBook
import com.example.data.model.SearchHit
import com.example.data.model.SemesterInfo
import com.example.data.model.StudyUnit
import com.example.data.model.ZoologyPaper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ZooNotesRepository(
    private val bookmarkDao: BookmarkDao,
    private val quizAttemptDao: QuizAttemptDao
) {
    val semesters: List<SemesterInfo> = ZoologyCurriculumRepository.semesters

    val allBookmarks: Flow<List<BookmarkEntity>> = bookmarkDao.getAllBookmarks()

    val bookmarkedIds: Flow<Set<String>> = bookmarkDao.getAllBookmarkedIds().map { it.toSet() }

    val quizAttemptsByChapter: Flow<Map<String, QuizAttemptEntity>> =
        quizAttemptDao.getAllAttempts().map { list -> list.associateBy { it.chapterId } }

    fun getPaperById(paperId: String): ZoologyPaper? =
        ZoologyCurriculumRepository.getPaperById(paperId)

    fun getDiagramById(diagramId: String): Pair<ZoologyPaper, BiologicalDiagram>? =
        ZoologyCurriculumRepository.getDiagramById(diagramId)

    fun search(query: String): List<SearchHit> = ZoologyCurriculumRepository.search(query)

    suspend fun toggleNoteBookmark(paper: ZoologyPaper, unit: StudyUnit, isCurrentlyBookmarked: Boolean) {
        if (isCurrentlyBookmarked) {
            bookmarkDao.deleteBookmarkById(unit.id)
        } else {
            bookmarkDao.upsertBookmark(
                BookmarkEntity(
                    itemId = unit.id,
                    type = BookmarkType.NOTE,
                    paperId = paper.id,
                    paperTitle = paper.title,
                    semester = paper.semester,
                    title = "Unit ${unit.unitNumber}: ${unit.title}",
                    subtitle = unit.summary
                )
            )
        }
    }

    suspend fun toggleDiagramBookmark(
        paper: ZoologyPaper,
        diagram: BiologicalDiagram,
        isCurrentlyBookmarked: Boolean
    ) {
        if (isCurrentlyBookmarked) {
            bookmarkDao.deleteBookmarkById(diagram.id)
        } else {
            bookmarkDao.upsertBookmark(
                BookmarkEntity(
                    itemId = diagram.id,
                    type = BookmarkType.DIAGRAM,
                    paperId = paper.id,
                    paperTitle = paper.title,
                    semester = paper.semester,
                    title = diagram.title,
                    subtitle = diagram.caption
                )
            )
        }
    }

    suspend fun toggleBookBookmark(
        paper: ZoologyPaper,
        book: ReferenceBook,
        isCurrentlyBookmarked: Boolean
    ) {
        if (isCurrentlyBookmarked) {
            bookmarkDao.deleteBookmarkById(book.id)
        } else {
            bookmarkDao.upsertBookmark(
                BookmarkEntity(
                    itemId = book.id,
                    type = BookmarkType.BOOK,
                    paperId = paper.id,
                    paperTitle = paper.title,
                    semester = paper.semester,
                    title = book.title,
                    subtitle = "${book.authors} (${book.edition})",
                    pdfUrl = book.pdfUrl
                )
            )
        }
    }

    suspend fun removeBookmark(itemId: String) {
        bookmarkDao.deleteBookmarkById(itemId)
    }

    suspend fun recordQuizAttempt(chapterId: String, score: Int, totalQuestions: Int) {
        val existing = quizAttemptDao.getAttempt(chapterId)
        val best = maxOf(existing?.bestScore ?: 0, score)
        quizAttemptDao.upsertAttempt(
            QuizAttemptEntity(
                chapterId = chapterId,
                bestScore = best,
                totalQuestions = totalQuestions
            )
        )
    }
}
