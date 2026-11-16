package com.example.data.model

import androidx.annotation.DrawableRes

enum class PaperDomainIcon {
    MICROORGANISM,
    ECOLOGY,
    ARTHROPOD,
    CELL,
    CHORDATE,
    NEURAL,
    BIOCHEM,
    ANATOMY,
    PHYSIOLOGY,
    METABOLISM,
    MOLECULAR,
    GENETICS,
    DEVELOPMENT,
    EVOLUTION
}

enum class VectorDiagramType {
    SYCON_CANAL_SYSTEM,
    ENERGY_PYRAMID_FOOD_WEB,
    WATER_VASCULAR_SYSTEM,
    CELL_CYCLE_MITOSIS,
    CHORDATE_CHARACTERS,
    SYNAPSE_ACTION_POTENTIAL,
    KREBS_CYCLE_FLOWCHART,
    VERTEBRATE_AORTIC_ARCHES,
    CARDIAC_CONDUCTION,
    UREA_CYCLE_FLOWCHART,
    LAC_OPERON_REGULATION,
    DROSOPHILA_SEX_DETERMINATION,
    FROG_GASTRULATION,
    HARDY_WEINBERG_EQUILIBRIUM
}

data class SemesterInfo(
    val semesterNumber: Int,
    val title: String,
    val subtitle: String,
    val papers: List<ZoologyPaper>
)

data class ZoologyPaper(
    val id: String,
    val semester: Int,
    val code: String,
    val title: String,
    val shortDescription: String,
    val credits: Int,
    val domainIcon: PaperDomainIcon,
    val units: List<StudyUnit>,
    val diagrams: List<BiologicalDiagram>,
    val books: List<ReferenceBook>,
    val pyqs: List<PreviousYearQuestion>,
    val quizChapters: List<QuizChapter>
)

data class StudyUnit(
    val id: String,
    val paperId: String,
    val unitNumber: Int,
    val title: String,
    val summary: String,
    val sections: List<NoteSection>,
    val keyDefinitions: List<KeyDefinition>,
    val highYieldPoints: List<String>
)

data class NoteSection(
    val heading: String,
    val bulletPoints: List<String>
)

data class KeyDefinition(
    val term: String,
    val definition: String
)

data class BiologicalDiagram(
    val id: String,
    val paperId: String,
    val title: String,
    val caption: String,
    val category: String,
    @DrawableRes val drawableResId: Int? = null,
    val vectorType: VectorDiagramType? = null,
    val labels: List<DiagramLabel>
)

data class DiagramLabel(
    val number: Int,
    val name: String,
    val function: String
)

data class ReferenceBook(
    val id: String,
    val paperId: String,
    val title: String,
    val authors: String,
    val edition: String,
    val topicTag: String,
    val description: String,
    val pdfUrl: String
)

data class PreviousYearQuestion(
    val id: String,
    val paperId: String,
    val year: String,
    val marks: Int,
    val question: String,
    val modelAnswer: String,
    val examinerTip: String
)

data class QuizChapter(
    val id: String,
    val paperId: String,
    val chapterTitle: String,
    val questions: List<QuizQuestion>
)

data class QuizQuestion(
    val id: String,
    val question: String,
    val options: List<String>,
    val correctIndex: Int,
    val explanation: String
)

enum class SearchResultType {
    PAPER,
    UNIT,
    DEFINITION,
    DIAGRAM,
    BOOK,
    PYQ
}

data class SearchHit(
    val id: String,
    val type: SearchResultType,
    val paperId: String,
    val semester: Int,
    val paperTitle: String,
    val title: String,
    val snippet: String,
    val initialTabIndex: Int,
    val targetItemId: String? = null
)
