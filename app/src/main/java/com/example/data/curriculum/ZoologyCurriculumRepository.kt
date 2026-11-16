package com.example.data.curriculum

import com.example.data.model.BiologicalDiagram
import com.example.data.model.SearchHit
import com.example.data.model.SearchResultType
import com.example.data.model.SemesterInfo
import com.example.data.model.ZoologyPaper

object ZoologyCurriculumRepository {
    val semesters: List<SemesterInfo> = listOf(
        Semesters1To2Data.semester1,
        Semesters1To2Data.semester2,
        Semesters3To4Data.semester3,
        Semesters3To4Data.semester4,
        Semesters5To6Data.semester5,
        Semesters5To6Data.semester6
    )

    val allPapers: List<ZoologyPaper> = semesters.flatMap { it.papers }

    fun getPaperById(paperId: String): ZoologyPaper? =
        allPapers.find { it.id == paperId }

    fun getDiagramById(diagramId: String): Pair<ZoologyPaper, BiologicalDiagram>? {
        for (paper in allPapers) {
            val diagram = paper.diagrams.find { it.id == diagramId }
            if (diagram != null) return paper to diagram
        }
        return null
    }

    fun search(query: String): List<SearchHit> {
        val q = query.trim().lowercase()
        if (q.isEmpty()) return emptyList()

        val hits = mutableListOf<SearchHit>()
        for (paper in allPapers) {
            if (
                paper.title.lowercase().contains(q) ||
                paper.code.lowercase().contains(q) ||
                paper.shortDescription.lowercase().contains(q)
            ) {
                hits += SearchHit(
                    id = "paper_${paper.id}",
                    type = SearchResultType.PAPER,
                    paperId = paper.id,
                    semester = paper.semester,
                    paperTitle = paper.title,
                    title = "${paper.code} • ${paper.title}",
                    snippet = paper.shortDescription,
                    initialTabIndex = 0
                )
            }

            for (unit in paper.units) {
                val contentMatch = unit.title.lowercase().contains(q) ||
                    unit.summary.lowercase().contains(q) ||
                    unit.sections.any { sec ->
                        sec.heading.lowercase().contains(q) ||
                            sec.bulletPoints.any { it.lowercase().contains(q) }
                    } ||
                    unit.highYieldPoints.any { it.lowercase().contains(q) }

                if (contentMatch) {
                    hits += SearchHit(
                        id = "unit_${unit.id}",
                        type = SearchResultType.UNIT,
                        paperId = paper.id,
                        semester = paper.semester,
                        paperTitle = paper.title,
                        title = "Unit ${unit.unitNumber}: ${unit.title}",
                        snippet = unit.summary,
                        initialTabIndex = 0,
                        targetItemId = unit.id
                    )
                }

                for (def in unit.keyDefinitions) {
                    if (def.term.lowercase().contains(q) || def.definition.lowercase().contains(q)) {
                        hits += SearchHit(
                            id = "def_${unit.id}_${def.term}",
                            type = SearchResultType.DEFINITION,
                            paperId = paper.id,
                            semester = paper.semester,
                            paperTitle = paper.title,
                            title = def.term,
                            snippet = def.definition,
                            initialTabIndex = 0,
                            targetItemId = unit.id
                        )
                    }
                }
            }

            for (diagram in paper.diagrams) {
                if (
                    diagram.title.lowercase().contains(q) ||
                    diagram.caption.lowercase().contains(q) ||
                    diagram.labels.any { it.name.lowercase().contains(q) }
                ) {
                    hits += SearchHit(
                        id = "diag_${diagram.id}",
                        type = SearchResultType.DIAGRAM,
                        paperId = paper.id,
                        semester = paper.semester,
                        paperTitle = paper.title,
                        title = diagram.title,
                        snippet = diagram.caption,
                        initialTabIndex = 1,
                        targetItemId = diagram.id
                    )
                }
            }

            for (book in paper.books) {
                if (
                    book.title.lowercase().contains(q) ||
                    book.authors.lowercase().contains(q) ||
                    book.topicTag.lowercase().contains(q)
                ) {
                    hits += SearchHit(
                        id = "book_${book.id}",
                        type = SearchResultType.BOOK,
                        paperId = paper.id,
                        semester = paper.semester,
                        paperTitle = paper.title,
                        title = book.title,
                        snippet = "${book.authors} • ${book.topicTag}",
                        initialTabIndex = 2,
                        targetItemId = book.id
                    )
                }
            }

            for (pyq in paper.pyqs) {
                if (pyq.question.lowercase().contains(q) || pyq.modelAnswer.lowercase().contains(q)) {
                    hits += SearchHit(
                        id = "pyq_${pyq.id}",
                        type = SearchResultType.PYQ,
                        paperId = paper.id,
                        semester = paper.semester,
                        paperTitle = paper.title,
                        title = pyq.question,
                        snippet = "${pyq.year} (${pyq.marks} Marks)",
                        initialTabIndex = 3,
                        targetItemId = pyq.id
                    )
                }
            }
        }
        return hits.distinctBy { it.id }.take(25)
    }
}
