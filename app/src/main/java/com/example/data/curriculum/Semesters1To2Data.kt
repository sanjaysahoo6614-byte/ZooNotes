package com.example.data.curriculum

import com.example.R
import com.example.data.model.BiologicalDiagram
import com.example.data.model.DiagramLabel
import com.example.data.model.KeyDefinition
import com.example.data.model.NoteSection
import com.example.data.model.PaperDomainIcon
import com.example.data.model.PreviousYearQuestion
import com.example.data.model.QuizChapter
import com.example.data.model.QuizQuestion
import com.example.data.model.ReferenceBook
import com.example.data.model.SemesterInfo
import com.example.data.model.StudyUnit
import com.example.data.model.VectorDiagramType
import com.example.data.model.ZoologyPaper

object Semesters1To2Data {
    val semester1 = SemesterInfo(
        semesterNumber = 1,
        title = "Semester 1",
        subtitle = "Lower Non-Chordates & Ecological Foundations",
        papers = listOf(nonChordates1Paper(), ecologyPaper())
    )

    val semester2 = SemesterInfo(
        semesterNumber = 2,
        title = "Semester 2",
        subtitle = "Coelomate Non-Chordates & Cellular Architecture",
        papers = listOf(nonChordates2Paper(), cellBiologyPaper())
    )

    private fun nonChordates1Paper() = ZoologyPaper(
        id = "sem1_nonchordates_1",
        semester = 1,
        code = "ZOO-CC101",
        title = "Non-Chordates I: Protista to Pseudocoelomates",
        shortDescription = "Protozoa, Porifera canal systems, Cnidarian polymorphism, Platyhelminthes & Nemathelminthes adaptations.",
        credits = 4,
        domainIcon = PaperDomainIcon.MICROORGANISM,
        units = listOf(
            StudyUnit(
                id = "nc1_u1",
                paperId = "sem1_nonchordates_1",
                unitNumber = 1,
                title = "Protista & Protozoa: Locomotion, Conjugation & Plasmodium",
                summary = "Acellular organization, ciliary and flagellar mechanics, nuclear dimorphism in Paramecium, and digenetic life cycle of Plasmodium vivax.",
                sections = listOf(
                    NoteSection(
                        heading = "Nuclear Dimorphism & Reproduction in Paramecium",
                        bulletPoints = listOf(
                            "Macronucleus is polyploid, kidney-shaped, and regulates somatic/metabolic functions.",
                            "Micronucleus is diploid, spherical, and governs reproductive division and genetic recombination.",
                            "Conjugation involves temporary pairing of compatible mating types via oral grooves, meiotic division of micronuclei, and reciprocal exchange of migratory pronuclei.",
                            "Binary fission is transverse in ciliates (Paramecium) vs longitudinal in flagellates (Euglena)."
                        )
                    ),
                    NoteSection(
                        heading = "Digenetic Life Cycle of Plasmodium vivax",
                        bulletPoints = listOf(
                            "Primary (definitive) host: Female Anopheles mosquito (sexual cycle / sporogony).",
                            "Secondary (intermediate) host: Human (asexual cycle / schizogony in liver and RBCs).",
                            "Infective stage to humans: Sporozoites injected with mosquito saliva; infective stage to mosquito: Gametocytes.",
                            "Schüffner's dots appear in infected erythrocytes during the trophozoite stage."
                        )
                    )
                ),
                keyDefinitions = listOf(
                    KeyDefinition("Conjugation", "Temporary union of two ciliates for reciprocal exchange of haploid micronuclear genetic material without producing immediate offspring."),
                    KeyDefinition("Osmoregulation", "Regulation of intracellular water balance by anterior and posterior contractile vacuoles via radial canals."),
                    KeyDefinition("Schizogony", "Multiple asexual fission occurring inside human hepatocytes and erythrocytes.")
                ),
                highYieldPoints = listOf(
                    "48-hour erythrocytic cycle in P. vivax causes benign tertian malaria paroxysms upon haemozoin release.",
                    "Contractile vacuole diastole fills from 6–10 radiating canals; systole expels water through a permanent pore."
                )
            ),
            StudyUnit(
                id = "nc1_u2",
                paperId = "sem1_nonchordates_1",
                unitNumber = 2,
                title = "Porifera: Canal Systems & Spicules",
                summary = "Cellular grade of organization, evolution from Asconoid to Leuconoid canal systems, and choanocyte physiology.",
                sections = listOf(
                    NoteSection(
                        heading = "Types of Canal Systems in Sponges",
                        bulletPoints = listOf(
                            "Asconoid (e.g., Leucosolenia): Simplest, radial symmetry; ostia -> spongocoel -> osculum.",
                            "Syconoid (e.g., Sycon/Scypha): Folded body wall creating incurrent and radial canals linked by prosopyles and apopyles.",
                            "Leuconoid (e.g., Spongilla): Most complex with flagellated chambers and obliteration of spongocoel; maximizes surface area for filter feeding."
                        )
                    ),
                    NoteSection(
                        heading = "Histology & Skeleton",
                        bulletPoints = listOf(
                            "Pinacocytes form the outer dermal epithelium; porocytes act as contractile ostia.",
                            "Choanocytes (collar cells) maintain water current and phagocytose food particles.",
                            "Archaeocytes are totipotent stem cells differentiating into scleroblasts and gametes."
                        )
                    )
                ),
                keyDefinitions = listOf(
                    KeyDefinition("Choanocyte", "Flagellated collar cell lining radial canals or flagellated chambers that drives water flow and traps plankton."),
                    KeyDefinition("Rhagon Type", "Pyramidal larval canal stage observed in Demospongiae development before adult leuconoid branching.")
                ),
                highYieldPoints = listOf(
                    "Water path in Sycon: Ostia -> Incurrent Canal -> Prosopyle -> Radial Canal -> Apopyle -> Spongocoel -> Osculum.",
                    "Calcareous spicules (CaCO3) characterize Calcarea; siliceous hexactine spicules characterize Hexactinellida."
                )
            ),
            StudyUnit(
                id = "nc1_u3",
                paperId = "sem1_nonchordates_1",
                unitNumber = 3,
                title = "Cnidaria & Helminthes: Polymorphism, Corals & Parasitism",
                summary = "Metagenesis in Obelia, division of labour in Siphonophora, coral reef formation, and parasitic adaptations in Fasciola and Ascaris.",
                sections = listOf(
                    NoteSection(
                        heading = "Polymorphism in Hydrozoa",
                        bulletPoints = listOf(
                            "Gastrozooids (nutritive), dactylozooids (defensive/sensory), and gonozooids (reproductive) exemplify division of labour.",
                            "Dimorphic alternation of asexual polypoid and sexual medusoid generations is termed metagenesis (Obelia)."
                        )
                    ),
                    NoteSection(
                        heading = "Parasitic Adaptations in Platyhelminthes & Nematoda",
                        bulletPoints = listOf(
                            "Thick tegument/cuticle resistant to host digestive enzymes and immune attack.",
                            "Adhesive organs: Acetabulum and oral sucker in Fasciola; scolex with hooks and suckers in Taenia.",
                            "Anaerobic respiration, loss of locomotor cilia, and enormous reproductive output with complex larval stages (miracidium -> sporocyst -> redia -> cercaria -> metacercaria)."
                        )
                    )
                ),
                keyDefinitions = listOf(
                    KeyDefinition("Metagenesis", "Alternation between an asexually reproducing diploid polyp and a sexually reproducing diploid medusa."),
                    KeyDefinition("Pseudocoelom", "Fluid-filled body cavity derived from the embryonic blastocoel, lined by mesoderm only on the outer body wall (e.g., Ascaris).")
                ),
                highYieldPoints = listOf(
                    "Darwin's Subsidence Theory explains fringing reef -> barrier reef -> atoll progression.",
                    "Ascaris lumbricoides shows sexual dimorphism: males are smaller with a curved posterior tail and pineal setae."
                )
            )
        ),
        diagrams = listOf(
            BiologicalDiagram(
                id = "diag_paramecium",
                paperId = "sem1_nonchordates_1",
                title = "Paramecium caudatum — Ultrastructure",
                caption = "Ventral view illustrating ciliary apparatus, oral groove, dimorphic nuclei, and osmoregulatory contractile vacuoles.",
                category = "Protozoa Anatomy plate",
                drawableResId = R.drawable.img_diagram_paramecium,
                labels = listOf(
                    DiagramLabel(1, "Cilia & Pellicle", "Locomotion and elastic outer cortical envelope with trichocysts."),
                    DiagramLabel(2, "Oral Groove & Cytostome", "Funnel food particles into nascent food vacuoles."),
                    DiagramLabel(3, "Macronucleus", "Large kidney-shaped vegetative nucleus governing metabolism."),
                    DiagramLabel(4, "Micronucleus", "Small diploid nucleus essential for conjugation and mitosis."),
                    DiagramLabel(5, "Contractile Vacuoles", "Anterior & posterior star-shaped vacuoles for osmoregulation.")
                )
            ),
            BiologicalDiagram(
                id = "diag_sycon_canal",
                paperId = "sem1_nonchordates_1",
                title = "Syconoid Canal System & Water Flow",
                caption = "Cross-sectional schematic showing water trajectory from dermal ostia through choanocyte-lined radial canals to osculum.",
                category = "Porifera Flowchart",
                vectorType = VectorDiagramType.SYCON_CANAL_SYSTEM,
                labels = listOf(
                    DiagramLabel(1, "Dermal Ostia", "Inhalant pores admitting ambient oxygenated water."),
                    DiagramLabel(2, "Incurrent Canal", "Pinacocyte-lined channel leading inward from surface."),
                    DiagramLabel(3, "Prosopyle", "Minute intercellular pore connecting incurrent to radial canal."),
                    DiagramLabel(4, "Radial Canal", "Lined by flagellated choanocytes for feeding and current generation."),
                    DiagramLabel(5, "Apopyle & Spongocoel", "Exit opening into central atrium leading out via osculum.")
                )
            )
        ),
        books = listOf(
            ReferenceBook(
                id = "book_kotpal_inverts",
                paperId = "sem1_nonchordates_1",
                title = "Modern Text Book of Zoology: Invertebrates",
                authors = "R.L. Kotpal",
                edition = "12th Edition (Rastogi Publications)",
                topicTag = "Protozoa to Echinodermata",
                description = "Gold-standard Indian B.Sc. Zoology textbook with detailed type studies of Paramecium, Sycon, Obelia, Fasciola, and Ascaris.",
                pdfUrl = "https://archive.org/details/in.ernet.dli.2015.462849"
            ),
            ReferenceBook(
                id = "book_jordan_verma",
                paperId = "sem1_nonchordates_1",
                title = "Invertebrate Zoology",
                authors = "E.L. Jordan & P.S. Verma",
                edition = "Revised Edition (S. Chand)",
                topicTag = "Classification & Type Studies",
                description = "Comprehensive diagrams, canal system comparisons, and university exam-focused anatomical descriptions.",
                pdfUrl = "https://archive.org/search?query=Invertebrate+Zoology+Jordan+Verma"
            )
        ),
        pyqs = listOf(
            PreviousYearQuestion(
                id = "pyq_nc1_1",
                paperId = "sem1_nonchordates_1",
                year = "2024 Univ. Exam",
                marks = 5,
                question = "Trace the path of water current in a Syconoid canal system and explain the role of choanocytes.",
                modelAnswer = "Water enters through dermal ostia into incurrent canals -> passes via prosopyles into choanocyte-lined radial canals -> exits through apopyles into the spongocoel -> leaves via the terminal osculum. Choanocytes beat their flagella asynchronously to create negative pressure, capturing suspended microbes on their microvillar collar.",
                examinerTip = "Always draw the labeled water-flow arrows clearly; 2 marks are reserved for the schematic."
            ),
            PreviousYearQuestion(
                id = "pyq_nc1_2",
                paperId = "sem1_nonchordates_1",
                year = "2023 Univ. Exam",
                marks = 5,
                question = "Explain nuclear dimorphism in Paramecium and state its significance during conjugation.",
                modelAnswer = "Paramecium possesses a polyploid macronucleus controlling somatic metabolism and a diploid micronucleus governing genetic continuity. During conjugation, the old macronucleus disintegrates while micronuclei undergo meiosis and cross-fertilization, restoring genetic vigor and preventing clonal senescence.",
                examinerTip = "Contrast macronucleus (amitosis) vs micronucleus (mitosis/meiosis)."
            )
        ),
        quizChapters = listOf(
            QuizChapter(
                id = "quiz_nc1_ch1",
                paperId = "sem1_nonchordates_1",
                chapterTitle = "Protozoa, Porifera & Cnidaria",
                questions = listOf(
                    QuizQuestion(
                        id = "q_nc1_1",
                        question = "Which stage of Plasmodium vivax is infective to the female Anopheles mosquito?",
                        options = listOf("Sporozoite", "Merozoite", "Gametocyte", "Trophozoite"),
                        correctIndex = 2,
                        explanation = "Gametocytes (micro- and macrogametocytes) circulate in human blood and develop into gametes inside the mosquito midgut; sporozoites are infective to humans."
                    ),
                    QuizQuestion(
                        id = "q_nc1_2",
                        question = "In a Syconoid sponge, prosopyles connect the:",
                        options = listOf("Radial canal to spongocoel", "Incurrent canal to radial canal", "Spongocoel to osculum", "Ostia to spongocoel"),
                        correctIndex = 1,
                        explanation = "Water flows from incurrent canals into radial canals through prosopyles, and exits radial canals into the spongocoel through apopyles."
                    ),
                    QuizQuestion(
                        id = "q_nc1_3",
                        question = "Which zooid in Physalia or Obelia is specialized for defense and prey capture?",
                        options = listOf("Gastrozooid", "Gonozooid", "Dactylozooid", "Pneumatophore"),
                        correctIndex = 2,
                        explanation = "Dactylozooids bear batteries of nematocysts for defense and prey capture, whereas gastrozooids are nutritive."
                    ),
                    QuizQuestion(
                        id = "q_nc1_4",
                        question = "The larval sequence in Fasciola hepatica includes which correct order?",
                        options = listOf(
                            "Miracidium -> Sporocyst -> Redia -> Cercaria",
                            "Cercaria -> Miracidium -> Redia -> Sporocyst",
                            "Onchosphere -> Miracidium -> Cysticercus",
                            "Rhabditiform -> Miracidium -> Metacercaria"
                        ),
                        correctIndex = 0,
                        explanation = "Miracidium infects the snail Limnaea, transforming sequentially into sporocyst, redia, cercaria, and encysted metacercaria."
                    )
                )
            )
        )
    )

    private fun ecologyPaper() = ZoologyPaper(
        id = "sem1_ecology",
        semester = 1,
        code = "ZOO-CC102",
        title = "Principles of Ecology",
        shortDescription = "Ecosystem energetics, biogeochemical cycles, population dynamics, r/K selection, and biodiversity conservation.",
        credits = 4,
        domainIcon = PaperDomainIcon.ECOLOGY,
        units = listOf(
            StudyUnit(
                id = "eco_u1",
                paperId = "sem1_ecology",
                unitNumber = 1,
                title = "Ecosystem Energetics & Ecological Pyramids",
                summary = "Laws of thermodynamics in ecosystems, Lindeman's 10% energy transfer law, food webs, and inverted vs upright pyramids.",
                sections = listOf(
                    NoteSection(
                        heading = "Energy Flow Models",
                        bulletPoints = listOf(
                            "Unidirectional energy flow governed by 1st and 2nd Laws of Thermodynamics.",
                            "Lindeman's 10% Law (1942): Only ~10% of assimilated energy passes from one trophic level to the next; ~90% is lost as respiratory heat.",
                            "Odum's Y-shaped (Universal) model connects Grazing Food Chain (GFC) and Detritus Food Chain (DFC)."
                        )
                    ),
                    NoteSection(
                        heading = "Ecological Pyramids",
                        bulletPoints = listOf(
                            "Pyramid of Energy is ALWAYS upright due to thermodynamic dissipation.",
                            "Pyramid of Biomass is upright in terrestrial grasslands/forests but inverted in aquatic ecosystems (phytoplankton turnover > zooplankton).",
                            "Pyramid of Numbers can be inverted in parasitic food chains or single-tree ecosystems."
                        )
                    )
                ),
                keyDefinitions = listOf(
                    KeyDefinition("Net Primary Productivity (NPP)", "Gross Primary Productivity minus autotrophic respiration (NPP = GPP - R); energy available to heterotrophs."),
                    KeyDefinition("Ecological Efficiency", "Percentage of energy transferred from trophic level n-1 to trophic level n.")
                ),
                highYieldPoints = listOf(
                    "Pyramid of Energy can NEVER be inverted in any stable natural ecosystem.",
                    "Aquatic biomass pyramid inversion occurs because phytoplankton have a rapid reproduction rate and short standing crop life."
                )
            ),
            StudyUnit(
                id = "eco_u2",
                paperId = "sem1_ecology",
                unitNumber = 2,
                title = "Population Growth, Life Tables & Succession",
                summary = "Exponential vs logistic growth curves, carrying capacity (K), Lotka-Volterra interactions, and hydrosere/xerosere succession.",
                sections = listOf(
                    NoteSection(
                        heading = "Population Growth Equations",
                        bulletPoints = listOf(
                            "Exponential (J-shaped) growth: dN/dt = rN when resources are unlimited.",
                            "Verhulst-Pearl Logistic (S-shaped/Sigmoid) growth: dN/dt = rN((K - N)/K), inflecting at N = K/2.",
                            "r-selected species favor high intrinsic growth rate and unpredictable habitats; K-selected species favor competitive stability near K."
                        )
                    ),
                    NoteSection(
                        heading = "Ecological Succession",
                        bulletPoints = listOf(
                            "Sequential process: Nudation -> Invasion -> Ecesis -> Aggregation -> Competition/Coaction -> Reaction -> Stabilization (Climax).",
                            "Primary succession begins on barren rock (xerosere) or open water (hydrosere); secondary succession occurs after disturbance with intact soil."
                        )
                    )
                ),
                keyDefinitions = listOf(
                    KeyDefinition("Carrying Capacity (K)", "Maximum population size an environment can sustainably support given limiting resources."),
                    KeyDefinition("Gause's Competitive Exclusion Principle", "Two species competing for the exact same limiting ecological niche cannot coexist indefinitely.")
                ),
                highYieldPoints = listOf(
                    "Maximum sustainable yield (MSY) under logistic growth occurs at N = K/2.",
                    "Keystone species exert disproportionate community control relative to their biomass (e.g., Pisaster sea star)."
                )
            )
        ),
        diagrams = listOf(
            BiologicalDiagram(
                id = "diag_energy_pyramid",
                paperId = "sem1_ecology",
                title = "Trophic Energy Pyramid & 10% Transfer",
                caption = "Lindeman's trophic energy cascade showing 10% assimilation per level and 90% metabolic heat loss.",
                category = "Ecosystem Flowchart",
                vectorType = VectorDiagramType.ENERGY_PYRAMID_FOOD_WEB,
                labels = listOf(
                    DiagramLabel(1, "Producers (10,000 kcal)", "Photoautotrophs converting solar radiation via GPP."),
                    DiagramLabel(2, "Primary Consumers (1,000 kcal)", "Herbivores assimilating ~10% of NPP."),
                    DiagramLabel(3, "Secondary Consumers (100 kcal)", "Primary carnivores; steep thermodynamic drop."),
                    DiagramLabel(4, "Tertiary Consumers (10 kcal)", "Apex predators limited to 4–5 trophic levels."),
                    DiagramLabel(5, "Decomposers & Heat Sink", "Detritivores recycle nutrients; energy dissipates as heat.")
                )
            )
        ),
        books = listOf(
            ReferenceBook(
                id = "book_odum_ecology",
                paperId = "sem1_ecology",
                title = "Fundamentals of Ecology",
                authors = "Eugene P. Odum & Gary W. Barrett",
                edition = "5th Edition",
                topicTag = "Ecosystems & Energy Flow",
                description = "Classic ecological reference covering energy flow models, biogeochemical cycles, and community succession.",
                pdfUrl = "https://archive.org/details/fundamentalsofec0000odum"
            ),
            ReferenceBook(
                id = "book_openstax_bio_eco",
                paperId = "sem1_ecology",
                title = "Biology 2e — Ecology Unit (OpenStax)",
                authors = "Clark, Douglas & Choi",
                edition = "OpenStax Digital PDF",
                topicTag = "Population & Community Ecology",
                description = "Peer-reviewed open-access textbook chapters on population demography, survivorship curves, and biodiversity.",
                pdfUrl = "https://openstax.org/details/books/biology-2e"
            )
        ),
        pyqs = listOf(
            PreviousYearQuestion(
                id = "pyq_eco_1",
                paperId = "sem1_ecology",
                year = "2024 Univ. Exam",
                marks = 5,
                question = "Derive and compare J-shaped and S-shaped population growth curves. At what value of N is growth rate maximum?",
                modelAnswer = "Exponential growth follows dN/dt = rN producing a J-shaped curve under unlimited resources. Logistic growth introduces environmental resistance (K-N)/K yielding dN/dt = rN((K-N)/K), an S-shaped sigmoid curve. Growth rate dN/dt reaches its inflection maximum when N = K/2.",
                examinerTip = "Plot N on Y-axis vs Time (t) on X-axis and mark the inflection point K/2 clearly."
            )
        ),
        quizChapters = listOf(
            QuizChapter(
                id = "quiz_eco_ch1",
                paperId = "sem1_ecology",
                chapterTitle = "Energetics & Population Dynamics",
                questions = listOf(
                    QuizQuestion(
                        id = "q_eco_1",
                        question = "According to Lindeman's 10% law, if producers fix 20,000 J of energy, how much reaches tertiary consumers?",
                        options = listOf("2,000 J", "200 J", "20 J", "2 J"),
                        correctIndex = 2,
                        explanation = "Producers (20,000 J) -> Herbivores (2,000 J) -> Secondary consumers (200 J) -> Tertiary consumers (20 J)."
                    ),
                    QuizQuestion(
                        id = "q_eco_2",
                        question = "Which ecological pyramid is inverted in a deep marine pelagic ecosystem?",
                        options = listOf("Pyramid of Energy", "Pyramid of Biomass", "Both Energy and Biomass", "Neither"),
                        correctIndex = 1,
                        explanation = "Aquatic biomass pyramids are often inverted because microscopic phytoplankton have lower standing biomass than zooplankton, though energy pyramids remain upright."
                    ),
                    QuizQuestion(
                        id = "q_eco_3",
                        question = "In the logistic equation dN/dt = rN((K-N)/K), population growth rate approaches zero when:",
                        options = listOf("N = K/2", "N = K", "r = 0 only", "N = 1"),
                        correctIndex = 1,
                        explanation = "As N approaches carrying capacity K, the term (K-N)/K approaches 0, halting net population growth."
                    )
                )
            )
        )
    )

    private fun nonChordates2Paper() = ZoologyPaper(
        id = "sem2_nonchordates_2",
        semester = 2,
        code = "ZOO-CC201",
        title = "Non-Chordates II: Coelomates",
        shortDescription = "Annelid metamerism, Arthropod respiration & metamorphosis, Molluscan torsion, and Echinoderm water vascular system.",
        credits = 4,
        domainIcon = PaperDomainIcon.ARTHROPOD,
        units = listOf(
            StudyUnit(
                id = "nc2_u1",
                paperId = "sem2_nonchordates_2",
                unitNumber = 1,
                title = "Annelida & Arthropoda: Metamerism, Vision & Metamorphosis",
                summary = "Evolution of true schizocoelomate metamerism, nephridial excretion, compound eye mosaic vision, and endocrine regulation of insect ecdysis.",
                sections = listOf(
                    NoteSection(
                        heading = "Metamerism & Excretion in Annelida",
                        bulletPoints = listOf(
                            "True metamerism: Serial repetition of homologous organs (nephridia, ganglia, septa) along the anteroposterior axis.",
                            "Pheretima exhibits septal (enteronephric, water-conserving), integumentary (exonephric), and pharyngeal nephridia."
                        )
                    ),
                    NoteSection(
                        heading = "Insect Metamorphosis & Hormonal Control",
                        bulletPoints = listOf(
                            "PTTH (Brain hormone) stimulates Prothoracic glands to secrete Ecdysone (molting hormone).",
                            "Corpora allata secrete Juvenile Hormone (JH): High JH -> larval-larval molt; Low JH -> pupal molt; Absent JH -> adult eclosion."
                        )
                    )
                ),
                keyDefinitions = listOf(
                    KeyDefinition("Ommatidium", "Individual optical unit of an arthropod compound eye containing corneal lens, crystalline cone, and rhabdome."),
                    KeyDefinition("Haemocoel", "Primary blood-filled body cavity of arthropods and molluscs formed by fusion of blastocoel with reduced coelom.")
                ),
                highYieldPoints = listOf(
                    "Apposition image forms in diurnal insects (sharp mosaic); superposition image forms in nocturnal insects (high sensitivity).",
                    "Crustacean larval sequence: Nauplius -> Zoea -> Mysis -> Megalopa."
                )
            ),
            StudyUnit(
                id = "nc2_u2",
                paperId = "sem2_nonchordates_2",
                unitNumber = 2,
                title = "Mollusca & Echinodermata: Torsion & Water Vascular System",
                summary = "Gastropod torsion and chiastoneury, cephalopod evolution, and Asterias hydraulic water vascular locomotion.",
                sections = listOf(
                    NoteSection(
                        heading = "Torsion in Gastropoda (e.g., Pila)",
                        bulletPoints = listOf(
                            "180-degree counterclockwise rotation of the visceral mass and mantle relative to the head-foot during veliger larval stage.",
                            "Results in crossing of pleurovisceral nerve cords into a figure-of-eight (chiastoneury/streptoneury) and anterior shift of mantle cavity."
                        )
                    ),
                    NoteSection(
                        heading = "Water Vascular System in Asterias",
                        bulletPoints = listOf(
                            "Coelomic hydraulic system: Madreporite -> Stone canal -> Ring canal (with Tiedemann's bodies & Polian vesicles) -> Radial canals -> Lateral canals -> Ampulla & Tube feet.",
                            "Mediates locomotion, adhesion, respiration, and prey handling."
                        )
                    )
                ),
                keyDefinitions = listOf(
                    KeyDefinition("Chiastoneury", "Figure-of-8 twisting of visceral nerve loop in gastropods caused by embryonic torsion."),
                    KeyDefinition("Madreporite", "Perforated calcareous sieve plate on the aboral surface of sea stars regulating water entry into the stone canal.")
                ),
                highYieldPoints = listOf(
                    "Echinoderms have bilateral larvae (Bipinnaria, Brachiolaria) despite pentaradial adult symmetry — confirming deuterostome ancestry.",
                    "Tiedemann's bodies produce coelomocytes in the sea star water vascular ring canal."
                )
            )
        ),
        diagrams = listOf(
            BiologicalDiagram(
                id = "diag_water_vascular",
                paperId = "sem2_nonchordates_2",
                title = "Asterias — Water Vascular System",
                caption = "Schematic of the pentaradial coelomic hydraulic network from madreporite to muscular ampullae and tube feet.",
                category = "Echinodermata Anatomy",
                vectorType = VectorDiagramType.WATER_VASCULAR_SYSTEM,
                labels = listOf(
                    DiagramLabel(1, "Madreporite", "Porous aboral sieve regulating seawater intake."),
                    DiagramLabel(2, "Stone Canal", "Calcareous-walled duct descending to circumoral ring."),
                    DiagramLabel(3, "Ring Canal & Tiedemann's Bodies", "Pentagonal central canal producing phagocytic coelomocytes."),
                    DiagramLabel(4, "Radial Canals", "Five canals extending along ambulacral grooves of each arm."),
                    DiagramLabel(5, "Ampulla & Tube Foot", "Hydraulic bulb & sucker generating suction locomotion.")
                )
            )
        ),
        books = listOf(
            ReferenceBook(
                id = "book_kotpal_coelomates",
                paperId = "sem2_nonchordates_2",
                title = "Modern Text Book of Zoology: Invertebrates (Coelomate Phyla)",
                authors = "R.L. Kotpal",
                edition = "12th Edition",
                topicTag = "Annelida, Arthropoda, Mollusca, Echinodermata",
                description = "Detailed unit-by-unit coverage of Pheretima, Palaemon, Pila, and Asterias water vascular mechanics.",
                pdfUrl = "https://archive.org/details/in.ernet.dli.2015.462849"
            ),
            ReferenceBook(
                id = "book_barnes_inverts",
                paperId = "sem2_nonchordates_2",
                title = "Invertebrate Zoology (Ruppert, Fox & Barnes)",
                authors = "E.E. Ruppert, R.S. Fox & R.D. Barnes",
                edition = "7th Edition",
                topicTag = "Functional Morphology & Torsion",
                description = "Authoritative functional anatomy reference for arthropod appendages, gastropod torsion, and deuterostome coelomates.",
                pdfUrl = "https://archive.org/search?query=Invertebrate+Zoology+Ruppert+Fox+Barnes"
            )
        ),
        pyqs = listOf(
            PreviousYearQuestion(
                id = "pyq_nc2_1",
                paperId = "sem2_nonchordates_2",
                year = "2024 Univ. Exam",
                marks = 5,
                question = "Explain the hormonal regulation of metamorphosis in holometabolous insects.",
                modelAnswer = "Neurosecretory cells of the brain release PTTH, stimulating the prothoracic gland to secrete Ecdysone (molting hormone). Simultaneously, the corpora allata secrete Juvenile Hormone (JH). High JH with ecdysone causes larva-to-larva molts; declining JH induces larva-to-pupa molt; absence of JH permits pupa-to-imago (adult) metamorphosis.",
                examinerTip = "Draw the 3-step hormone arrow cascade: High JH -> Low JH -> Zero JH."
            )
        ),
        quizChapters = listOf(
            QuizChapter(
                id = "quiz_nc2_ch1",
                paperId = "sem2_nonchordates_2",
                chapterTitle = "Coelomate Non-Chordates",
                questions = listOf(
                    QuizQuestion(
                        id = "q_nc2_1",
                        question = "Absence of Juvenile Hormone (JH) in the presence of Ecdysone triggers:",
                        options = listOf("Larval-larval molt", "Pupal-adult eclosion", "Diapause arrest", "Apolysis inhibition"),
                        correctIndex = 1,
                        explanation = "When JH titers drop to zero while ecdysone surges, the pupa undergoes final metamorphosis into an adult insect."
                    ),
                    QuizQuestion(
                        id = "q_nc2_2",
                        question = "Which structure produces coelomocytes inside the water vascular system of Asterias?",
                        options = listOf("Madreporite", "Tiedemann's bodies", "Stone canal", "Podia"),
                        correctIndex = 1,
                        explanation = "Nine small glandular Tiedemann's bodies attached to the inner wall of the ring canal manufacture coelomocytes."
                    ),
                    QuizQuestion(
                        id = "q_nc2_3",
                        question = "Crossing of the visceral nerve loop into a figure-of-8 during gastropod torsion is called:",
                        options = listOf("Metamerism", "Chiastoneury", "Detorsion", "Tagmosis"),
                        correctIndex = 1,
                        explanation = "180-degree torsion twists the pleurovisceral connectives into an X-shape known as chiastoneury or streptoneury."
                    )
                )
            )
        )
    )

    private fun cellBiologyPaper() = ZoologyPaper(
        id = "sem2_cell_biology",
        semester = 2,
        code = "ZOO-CC202",
        title = "Cell Biology",
        shortDescription = "Fluid mosaic plasma membrane, organelle ultrastructure, mitochondrial bioenergetics, and cell cycle checkpoints.",
        credits = 4,
        domainIcon = PaperDomainIcon.CELL,
        units = listOf(
            StudyUnit(
                id = "cb_u1",
                paperId = "sem2_cell_biology",
                unitNumber = 1,
                title = "Plasma Membrane & Endomembrane Trafficking",
                summary = "Singer-Nicolson Fluid Mosaic Model, lipid rafts, Na+/K+ ATPase active transport, and ER-to-Golgi vesicular sorting.",
                sections = listOf(
                    NoteSection(
                        heading = "Fluid Mosaic Model (1972)",
                        bulletPoints = listOf(
                            "Amphipathic phospholipid bilayer with hydrophobic acyl tails inward and hydrophilic head groups outward.",
                            "Integral (transmembrane) proteins span the bilayer; peripheral proteins bind electrostatically to surfaces.",
                            "Cholesterol acts as a bidirectional fluidity buffer; glycocalyx oligosaccharides mediate cell-cell recognition."
                        )
                    ),
                    NoteSection(
                        heading = "Endomembrane System (GERL)",
                        bulletPoints = listOf(
                            "Rough ER synthesizes secretory/membrane proteins (SRP-mediated translocation).",
                            "Golgi apparatus (cis -> medial -> trans face) performs O-linked glycosylation, mannose-6-phosphate tagging for lysosomes, and sorting."
                        )
                    )
                ),
                keyDefinitions = listOf(
                    KeyDefinition("Na+/K+-ATPase Pump", "P-type primary active antiporter exporting 3 Na+ out and importing 2 K+ per ATP hydrolyzed."),
                    KeyDefinition("Mannose-6-Phosphate (M6P)", "Sorting signal added in cis-Golgi directing acid hydrolases to lysosomes.")
                ),
                highYieldPoints = listOf(
                    "COPII vesicles transport cargo anterograde (ER -> Golgi); COPI vesicles mediate retrograde retrieval (Golgi -> ER).",
                    "I-cell disease results from defective M6P tagging in the Golgi apparatus."
                )
            ),
            StudyUnit(
                id = "cb_u2",
                paperId = "sem2_cell_biology",
                unitNumber = 2,
                title = "Mitochondria, Cell Cycle & Meiosis",
                summary = "Semi-autonomous mitochondrial organization, Cyclin-CDK checkpoints (G1/S, G2/M, Spindle), and Meiosis I chiasmata.",
                sections = listOf(
                    NoteSection(
                        heading = "Mitochondrial Ultrastructure",
                        bulletPoints = listOf(
                            "Double-membrane organelle: porin-rich outer membrane; cardiolipin-rich inner membrane folded into cristae.",
                            "Matrix houses Krebs cycle enzymes, circular dsDNA, and 70S (mitoribosomes) supporting endosymbiotic origin.",
                            "F0-F1 ATP synthase complexes (oxysomes) line cristae to couple proton motive force to ATP synthesis."
                        )
                    ),
                    NoteSection(
                        heading = "Cell Cycle Checkpoints & Meiosis I",
                        bulletPoints = listOf(
                            "G1/S Restriction checkpoint (Cyclin E-CDK2 & p53/Rb); G2/M checkpoint (MPF = Cyclin B + CDK1).",
                            "Prophase I substages: Leptotene -> Zygotene (synapsis) -> Pachytene (crossing over via recombination nodules) -> Diplotene (chiasmata visible) -> Diakinesis (terminalization)."
                        )
                    )
                ),
                keyDefinitions = listOf(
                    KeyDefinition("MPF (Maturation Promoting Factor)", "Heterodimer of Cyclin B and CDK1 driving nuclear envelope breakdown and mitotic entry."),
                    KeyDefinition("Synaptonemal Complex", "Proteinaceous ladder-like scaffold holding homologous chromosomes together during Zygotene–Pachytene.")
                ),
                highYieldPoints = listOf(
                    "p53 ('Guardian of the Genome') halts the cell at G1 via p21-mediated CDK inhibition upon DNA damage.",
                    "Crossing over occurs strictly between non-sister chromatids of homologous chromosomes in Pachytene."
                )
            )
        ),
        diagrams = listOf(
            BiologicalDiagram(
                id = "diag_mitochondria",
                paperId = "sem2_cell_biology",
                title = "Mitochondrion — Cutaway Ultrastructure",
                caption = "Semi-autonomous organelle architecture showing outer membrane, cristae folds, matrix mtDNA, and F0-F1 ATP synthase.",
                category = "Cell Organelle Plate",
                drawableResId = R.drawable.img_diagram_mitochondria,
                labels = listOf(
                    DiagramLabel(1, "Outer Membrane", "Smooth membrane containing voltage-dependent anion channels (porins)."),
                    DiagramLabel(2, "Inner Membrane & Cristae", "Cardiolipin-rich impermeable folds hosting ETC Complexes I–IV."),
                    DiagramLabel(3, "Intermembrane Space", "Accumulates H+ protons pumped by ETC to generate ΔpH."),
                    DiagramLabel(4, "Mitochondrial Matrix", "Site of TCA cycle, pyruvate oxidation, circular mtDNA & 70S ribosomes."),
                    DiagramLabel(5, "F0-F1 ATP Synthase", "Rotary molecular turbine converting proton gradient into ATP.")
                )
            ),
            BiologicalDiagram(
                id = "diag_cell_cycle",
                paperId = "sem2_cell_biology",
                title = "Eukaryotic Cell Cycle & Checkpoints",
                caption = "Circular regulatory diagram highlighting G1, S, G2, M phases and Cyclin-CDK restriction checkpoints.",
                category = "Cell Division Flowchart",
                vectorType = VectorDiagramType.CELL_CYCLE_MITOSIS,
                labels = listOf(
                    DiagramLabel(1, "G1 Phase & G0", "Cell growth, RNA/protein synthesis; quiescence branch G0."),
                    DiagramLabel(2, "G1/S Checkpoint (p53/Rb)", "Verifies DNA integrity and growth factor signals before replication."),
                    DiagramLabel(3, "S Phase", "Semi-conservative DNA replication and centrosome duplication."),
                    DiagramLabel(4, "G2/M Checkpoint (MPF)", "Cyclin B-CDK1 triggers chromosome condensation and spindle assembly."),
                    DiagramLabel(5, "Spindle Assembly Checkpoint", "Ensures kinetochore-microtubule biorientation before Anaphase.")
                )
            )
        ),
        books = listOf(
            ReferenceBook(
                id = "book_karp_cell",
                paperId = "sem2_cell_biology",
                title = "Karp's Cell and Molecular Biology",
                authors = "Gerald Karp, Janet Iwasa & Wallace Marshall",
                edition = "9th Edition (Wiley)",
                topicTag = "Membranes, Organelles & Cell Cycle",
                description = "Clear experimental biology explanations of fluid mosaic dynamics, vesicular sorting, and CDK checkpoints.",
                pdfUrl = "https://archive.org/search?query=Karp+Cell+and+Molecular+Biology"
            ),
            ReferenceBook(
                id = "book_alberts_cell",
                paperId = "sem2_cell_biology",
                title = "Molecular Biology of the Cell (NCBI Bookshelf)",
                authors = "Bruce Alberts et al.",
                edition = "4th Edition Open Archive",
                topicTag = "Organelles & Cytoskeleton",
                description = "Free authoritative NCBI Bookshelf reference covering mitochondrial bioenergetics and mitotic spindle mechanics.",
                pdfUrl = "https://www.ncbi.nlm.nih.gov/books/NBK21054/"
            )
        ),
        pyqs = listOf(
            PreviousYearQuestion(
                id = "pyq_cb_1",
                paperId = "sem2_cell_biology",
                year = "2024 Univ. Exam",
                marks = 5,
                question = "Describe the substages of Meiotic Prophase I and state the significance of Pachytene and Diplotene.",
                modelAnswer = "Prophase I consists of five substages: (1) Leptotene (chromatin condensation into bouquet), (2) Zygotene (homolog pairing/synapsis via synaptonemal complex forming bivalents), (3) Pachytene (crossing over between non-sister chromatids catalyzed by recombinase), (4) Diplotene (dissolution of synaptonemal complex revealing X-shaped chiasmata), and (5) Diakinesis (chiasma terminalization and nuclear envelope breakdown).",
                examinerTip = "Use the mnemonic 'Lazy Zebra Painted Double Dots' for L-Z-P-D-D."
            )
        ),
        quizChapters = listOf(
            QuizChapter(
                id = "quiz_cb_ch1",
                paperId = "sem2_cell_biology",
                chapterTitle = "Membranes, Organelles & Cell Cycle",
                questions = listOf(
                    QuizQuestion(
                        id = "q_cb_1",
                        question = "Which Golgi-added tag directs hydrolytic enzymes specifically to lysosomes?",
                        options = listOf("Ubiquitin", "Mannose-6-phosphate", "N-acetylglucosamine", "KDEL sequence"),
                        correctIndex = 1,
                        explanation = "Mannose-6-phosphate receptors in the trans-Golgi network package acid hydrolases into clathrin-coated vesicles bound for endosomes/lysosomes."
                    ),
                    QuizQuestion(
                        id = "q_cb_2",
                        question = "During which substage of Prophase I do X-shaped chiasmata first become microscopically distinct?",
                        options = listOf("Zygotene", "Pachytene", "Diplotene", "Leptotene"),
                        correctIndex = 2,
                        explanation = "Synaptonemal complexes dissolve in Diplotene, allowing homologs to separate slightly except at crossover sites (chiasmata)."
                    ),
                    QuizQuestion(
                        id = "q_cb_3",
                        question = "Maturation Promoting Factor (MPF) consists of:",
                        options = listOf("Cyclin D + CDK4", "Cyclin B + CDK1", "Cyclin E + CDK2", "p53 + p21"),
                        correctIndex = 1,
                        explanation = "Cyclin B complexed with CDK1 (Cdc2) drives the G2/M transition into mitosis."
                    )
                )
            )
        )
    )
}
