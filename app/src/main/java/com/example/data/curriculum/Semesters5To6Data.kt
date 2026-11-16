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

object Semesters5To6Data {
    val semester5 = SemesterInfo(
        semesterNumber = 5,
        title = "Semester 5",
        subtitle = "Molecular Biology & Classical/Modern Genetics",
        papers = listOf(molecularBiologyPaper(), geneticsPaper())
    )

    val semester6 = SemesterInfo(
        semesterNumber = 6,
        title = "Semester 6",
        subtitle = "Developmental Biology & Evolutionary Synthesis",
        papers = listOf(developmentalBiologyPaper(), evolutionPaper())
    )

    private fun molecularBiologyPaper() = ZoologyPaper(
        id = "sem5_mol_bio",
        semester = 5,
        code = "ZOO-CC501",
        title = "Molecular Biology",
        shortDescription = "Semi-conservative DNA replication fork, RNA processing, genetic code wobble, and Lac/Trp operon gene regulation.",
        credits = 4,
        domainIcon = PaperDomainIcon.MOLECULAR,
        units = listOf(
            StudyUnit(
                id = "mb_u1",
                paperId = "sem5_mol_bio",
                unitNumber = 1,
                title = "DNA Replication & Repair Mechanisms",
                summary = "Meselson-Stahl proof, prokaryotic replication fork enzymology (DnaB, Primase, Pol III, Pol I), and telomerase end-replication.",
                sections = listOf(
                    NoteSection(
                        heading = "Prokaryotic Replication Fork Mechanics",
                        bulletPoints = listOf(
                            "Initiator DnaA binds oriC; DnaB helicase unwinds dsDNA; SSB proteins stabilize ssDNA; DNA Gyrase relieves positive supercoils ahead of fork.",
                            "Primase (DnaG) synthesizes short 5'->3' RNA primers.",
                            "DNA Polymerase III synthesizes the leading strand continuously (5'->3') and lagging strand discontinuously as Okazaki fragments.",
                            "DNA Polymerase I removes RNA primers via 5'->3' exonuclease activity; DNA Ligase seals phosphodiester nicks."
                        )
                    )
                ),
                keyDefinitions = listOf(
                    KeyDefinition("Okazaki Fragments", "Short nascent DNA-RNA fragments synthesized 5'->3' away from the fork on the lagging template strand."),
                    KeyDefinition("Telomerase", "Ribonucleoprotein reverse transcriptase carrying an internal RNA template to extend 3' G-rich chromosomal telomeres.")
                ),
                highYieldPoints = listOf(
                    "ALL DNA polymerases synthesize exclusively in the 5' -> 3' direction and proofread via 3' -> 5' exonuclease.",
                    "In eukaryotes: Pol α initiates primers, Pol δ synthesizes lagging strand, Pol ε synthesizes leading strand."
                )
            ),
            StudyUnit(
                id = "mb_u2",
                paperId = "sem5_mol_bio",
                unitNumber = 2,
                title = "Transcription, Splicing & Lac Operon Regulation",
                summary = "Eukaryotic RNA Pol II capping/splicing/polyadenylation, genetic code degeneracy, and Jacob-Monod inducible Lac operon.",
                sections = listOf(
                    NoteSection(
                        heading = "Jacob-Monod Lac Operon (Inducible Catabolic)",
                        bulletPoints = listOf(
                            "Structural genes: lacZ (β-galactosidase), lacY (permease), lacA (transacetylase).",
                            "Negative control: Active lacI repressor binds Operator (O) blocking RNA Pol in absence of allolactose.",
                            "Positive control: Low glucose raises cAMP -> cAMP-CAP complex binds upstream of Promoter, boosting transcription 50-fold."
                        )
                    )
                ),
                keyDefinitions = listOf(
                    KeyDefinition("Wobble Hypothesis", "Crick's rule explaining how the 5' anticodon base of tRNA forms non-Watson-Crick pairs with the 3' mRNA codon base."),
                    KeyDefinition("Spliceosome", "snRNP ribonucleoprotein complex (U1, U2, U4/U6, U5) excising introns via a lariat intermediate.")
                ),
                highYieldPoints = listOf(
                    "Maximal Lac operon expression requires BOTH presence of Lactose (allolactose inactivates repressor) AND absence of Glucose (high cAMP-CAP).",
                    "In Rho-independent termination, a GC-rich hairpin followed by a poly-U tract dissociates RNA Pol."
                )
            )
        ),
        diagrams = listOf(
            BiologicalDiagram(
                id = "diag_dna_replication",
                paperId = "sem5_mol_bio",
                title = "DNA Replication Fork — Enzymatic Complex",
                caption = "Semi-discontinuous DNA synthesis showing helicase unwinding, leading strand, and Okazaki fragments on the lagging strand.",
                category = "Molecular Biology Plate",
                drawableResId = R.drawable.img_diagram_dna_replication,
                labels = listOf(
                    DiagramLabel(1, "DNA Helicase (DnaB)", "Unwinds parental duplex using ATP hydrolysis at the fork vertex."),
                    DiagramLabel(2, "Leading Strand (Continuous)", "Synthesized 5'->3' toward the advancing replication fork."),
                    DiagramLabel(3, "Lagging Strand & Okazaki Fragments", "Synthesized discontinuously away from fork with multiple primers."),
                    DiagramLabel(4, "RNA Primase & DNA Pol III", "Launches 3'-OH primer and extends high-processivity DNA."),
                    DiagramLabel(5, "DNA Pol I & Ligase", "Excises RNA primers and seals nicked sugar-phosphate backbone.")
                )
            ),
            BiologicalDiagram(
                id = "diag_lac_operon",
                paperId = "sem5_mol_bio",
                title = "Lac Operon — Inducible & CAP Regulation",
                caption = "Jacob-Monod transcriptional switch comparing repressed (-Lactose) vs maximally active (+Lactose / -Glucose) states.",
                category = "Gene Regulation Schematic",
                vectorType = VectorDiagramType.LAC_OPERON_REGULATION,
                labels = listOf(
                    DiagramLabel(1, "Regulator Gene (lacI)", "Constitutively expresses tetrameric Lac repressor protein."),
                    DiagramLabel(2, "CAP Site & Promoter (P)", "Binds cAMP-CAP activator when glucose is scarce."),
                    DiagramLabel(3, "Operator (O)", "DNA switch bound by repressor unless allolactose is present."),
                    DiagramLabel(4, "lacZ / lacY / lacA", "Polycistronic mRNA encoding β-galactosidase, permease, transacetylase.")
                )
            )
        ),
        books = listOf(
            ReferenceBook(
                id = "book_watson_molbio",
                paperId = "sem5_mol_bio",
                title = "Molecular Biology of the Gene",
                authors = "James D. Watson et al.",
                edition = "7th Edition (Pearson)",
                topicTag = "Replication, Transcription & Operons",
                description = "Foundational molecular biology treatise detailing DNA replication enzymology, splicing, and prokaryotic gene switches.",
                pdfUrl = "https://archive.org/search?query=Watson+Molecular+Biology+of+the+Gene"
            ),
            ReferenceBook(
                id = "book_verma_agarwal_mol",
                paperId = "sem5_mol_bio",
                title = "Cell Biology, Genetics, Molecular Biology, Evolution and Ecology",
                authors = "P.S. Verma & V.K. Agarwal",
                edition = "Multicolour Edition (S. Chand)",
                topicTag = "B.Sc. Integrated Core Notes",
                description = "Classic Indian undergraduate reference with crisp operon diagrams and replication comparisons.",
                pdfUrl = "https://archive.org/search?query=Verma+Agarwal+Cell+Biology+Genetics+Molecular+Biology"
            )
        ),
        pyqs = listOf(
            PreviousYearQuestion(
                id = "pyq_mb_1",
                paperId = "sem5_mol_bio",
                year = "2024 Univ. Exam",
                marks = 5,
                question = "Explain both negative and positive regulation of the Lac operon in E. coli.",
                modelAnswer = "Negative regulation is mediated by the lacI repressor, which binds the operator (O) and sterically blocks RNA polymerase when lactose is absent; allolactose (inducer) binds the repressor causing a conformational shift so it releases O. Positive regulation occurs via cAMP-CAP: when glucose is absent, intracellular cAMP rises, binds CAP, and recruits RNA polymerase strongly to the weak lac promoter.",
                examinerTip = "Draw both 'Glucose+ / Lactose+' (basal) vs 'Glucose- / Lactose+' (high expression) states."
            )
        ),
        quizChapters = listOf(
            QuizChapter(
                id = "quiz_mb_ch1",
                paperId = "sem5_mol_bio",
                chapterTitle = "Replication, Transcription & Operons",
                questions = listOf(
                    QuizQuestion(
                        id = "q_mb_1",
                        question = "Which enzyme removes RNA primers from Okazaki fragments in E. coli?",
                        options = listOf("DNA Polymerase III", "DNA Polymerase I", "DNA Helicase", "Topoisomerase II"),
                        correctIndex = 1,
                        explanation = "DNA Polymerase I possesses unique 5'->3' exonuclease activity to excise RNA primers and replace them with DNA."
                    ),
                    QuizQuestion(
                        id = "q_mb_2",
                        question = "Maximal transcription of the E. coli Lac operon occurs when:",
                        options = listOf("Glucose high, Lactose high", "Glucose low, Lactose low", "Glucose low, Lactose high", "Glucose high, Lactose low"),
                        correctIndex = 2,
                        explanation = "High lactose removes the lacI repressor, while low glucose elevates cAMP so CAP strongly activates RNA polymerase."
                    )
                )
            )
        )
    )

    private fun geneticsPaper() = ZoologyPaper(
        id = "sem5_genetics",
        semester = 5,
        code = "ZOO-CC502",
        title = "Principles of Genetics",
        shortDescription = "Epistasis, linkage & 3-point chromosome mapping, Drosophila genic balance sex determination, and chromosomal aberrations.",
        credits = 4,
        domainIcon = PaperDomainIcon.GENETICS,
        units = listOf(
            StudyUnit(
                id = "gen_u1",
                paperId = "sem5_genetics",
                unitNumber = 1,
                title = "Gene Interactions, Linkage & Sex Determination",
                summary = "Modified dihybrid ratios (9:7, 9:3:4, 12:3:1), Morgan's linkage & recombination mapping, and Bridges' Genic Balance Theory.",
                sections = listOf(
                    NoteSection(
                        heading = "Epistasis & Modified Mendelian Ratios",
                        bulletPoints = listOf(
                            "Complementary genes: 9:7 (both dominant alleles required for phenotype).",
                            "Recessive epistasis (e.g., coat color in mice / Bombay phenotype): 9:3:4.",
                            "Dominant epistasis (summer squash fruit color): 12:3:1.",
                            "Duplicate dominant genes (Capsella): 15:1."
                        )
                    ),
                    NoteSection(
                        heading = "Bridges' Genic Balance Theory in Drosophila",
                        bulletPoints = listOf(
                            "Sex in Drosophila is governed by the X/A ratio (number of X chromosomes to sets of autosomes), NOT the Y chromosome.",
                            "X/A = 1.0 -> Normal Female; X/A = 0.5 -> Normal Male; X/A > 1.0 -> Metafemale; 0.5 < X/A < 1.0 -> Intersex.",
                            "Y chromosome carries fertility factors only (XO fly is sterile male; XXY fly is fertile female)."
                        )
                    )
                ),
                keyDefinitions = listOf(
                    KeyDefinition("Map Unit (centiMorgan, cM)", "1% recombination frequency between two linked loci on the same chromosome."),
                    KeyDefinition("Lyonization", "Random transcriptional inactivation of one X chromosome as a Barr body in somatic cells of mammalian females (dosage compensation).")
                ),
                highYieldPoints = listOf(
                    "Maximum observable recombination frequency between two loci on a chromosome is 50% (behaves like independent assortment).",
                    "In humans, sex is strictly Y-determined via the SRY gene (TDF); in Drosophila, sex depends on the X:A ratio."
                )
            )
        ),
        diagrams = listOf(
            BiologicalDiagram(
                id = "diag_drosophila_sex",
                paperId = "sem5_genetics",
                title = "Drosophila Genic Balance (X/A Ratio) Chart",
                caption = "Bridges' chromosomal balance matrix comparing Drosophila X:A ratios vs mammalian SRY sex determination.",
                category = "Genetics Matrix",
                vectorType = VectorDiagramType.DROSOPHILA_SEX_DETERMINATION,
                labels = listOf(
                    DiagramLabel(1, "X/A = 1.5 (3X:2A)", "Metafemale (superfemale) — weak & sterile."),
                    DiagramLabel(2, "X/A = 1.0 (2X:2A or XXY:2A)", "Normal fertile female regardless of Y presence."),
                    DiagramLabel(3, "X/A = 0.67 (2X:3A)", "Intersex exhibiting mosaic male/female traits."),
                    DiagramLabel(4, "X/A = 0.5 (XY:2A or XO:2A)", "Normal male (XO is sterile due to missing Y fertility genes)."),
                    DiagramLabel(5, "X/A = 0.33 (1X:3A)", "Metamale — sterile and low viability.")
                )
            )
        ),
        books = listOf(
            ReferenceBook(
                id = "book_gardner_genetics",
                paperId = "sem5_genetics",
                title = "Principles of Genetics",
                authors = "E.J. Gardner, M.J. Simmons & D.P. Snustad",
                edition = "8th Edition (Wiley)",
                topicTag = "Linkage, Epistasis & Chromosomes",
                description = "Classic B.Sc. genetics textbook with solved 3-point test cross mapping problems and sex-determination tables.",
                pdfUrl = "https://archive.org/search?query=Gardner+Simmons+Snustad+Principles+of+Genetics"
            ),
            ReferenceBook(
                id = "book_klug_cummings",
                paperId = "sem5_genetics",
                title = "Concepts of Genetics",
                authors = "William S. Klug, Michael R. Cummings et al.",
                edition = "12th Edition (Pearson)",
                topicTag = "Cytogenetics & Dosage Compensation",
                description = "Detailed visual treatments of chromosomal inversions, translocations, and X-inactivation.",
                pdfUrl = "https://archive.org/search?query=Klug+Cummings+Concepts+of+Genetics"
            )
        ),
        pyqs = listOf(
            PreviousYearQuestion(
                id = "pyq_gen_1",
                paperId = "sem5_genetics",
                year = "2024 Univ. Exam",
                marks = 5,
                question = "Contrast sex determination in Drosophila melanogaster and Homo sapiens, citing XO and XXY phenotypes.",
                modelAnswer = "In Drosophila (Bridges' Genic Balance), sex depends on the X:Autosome ratio: XXY (2X:2A, ratio 1.0) is a fertile female, and XO (1X:2A, ratio 0.5) is a sterile male because Y only carries sperm-motility fertility factors. In humans, the Y-linked SRY gene acts as a dominant male switch: XXY (Klinefelter) is male, and XO (Turner) is female.",
                examinerTip = "Present a crisp side-by-side table for XO and XXY in Fly vs Human."
            )
        ),
        quizChapters = listOf(
            QuizChapter(
                id = "quiz_gen_ch1",
                paperId = "sem5_genetics",
                chapterTitle = "Epistasis, Linkage & Sex Determination",
                questions = listOf(
                    QuizQuestion(
                        id = "q_gen_1",
                        question = "A 9:3:4 F2 dihybrid phenotypic ratio is diagnostic of:",
                        options = listOf("Dominant epistasis", "Recessive epistasis", "Complementary gene interaction", "Duplicate genes"),
                        correctIndex = 1,
                        explanation = "In recessive epistasis, homozygosity at one locus (aa) masks expression at the second locus (B/- or bb), merging 3 + 1 into 4."
                    ),
                    QuizQuestion(
                        id = "q_gen_2",
                        question = "In Drosophila melanogaster, an individual with karyotype 2A + XXY will develop as:",
                        options = listOf("Sterile male", "Fertile female", "Intersex", "Metamale"),
                        correctIndex = 1,
                        explanation = "With 2 X chromosomes and 2 sets of autosomes (X/A = 1.0), the fly develops as a normal fertile female."
                    )
                )
            )
        )
    )

    private fun developmentalBiologyPaper() = ZoologyPaper(
        id = "sem6_dev_bio",
        semester = 6,
        code = "ZOO-CC601",
        title = "Developmental Biology",
        shortDescription = "Gametogenesis, cortical block to polyspermy, cleavage patterns, amphibian gastrulation, and Spemann's embryonic induction.",
        credits = 4,
        domainIcon = PaperDomainIcon.DEVELOPMENT,
        units = listOf(
            StudyUnit(
                id = "db_u1",
                paperId = "sem6_dev_bio",
                unitNumber = 1,
                title = "Fertilization, Gastrulation & Spemann's Organizer",
                summary = "Acrosomal reaction, fast & slow blocks to polyspermy, morphogenetic movements (invagination, involution, epiboly), and primary embryonic induction.",
                sections = listOf(
                    NoteSection(
                        heading = "Blocks to Polyspermy & Gastrulation",
                        bulletPoints = listOf(
                            "Fast block: Transient Na+-mediated depolarization of egg plasma membrane (~+20 mV).",
                            "Slow block: IP3-triggered intracellular Ca2+ wave induces cortical granule exocytosis, hardening the fertilization envelope.",
                            "Frog gastrulation begins at the grey crescent (dorsal blastopore lip) via bottle cell invagination, mesodermal involution, and ectodermal epiboly."
                        )
                    ),
                    NoteSection(
                        heading = "Spemann & Mangold Organizer Experiment (1924)",
                        bulletPoints = listOf(
                            "Transplanting the dorsal lip of the blastopore from a pigmented newt gastrula into the ventral side of an unpigmented host induced a complete secondary embryonic axis.",
                            "Molecular signals: Organizer secretes BMP4 inhibitors (Noggin, Chordin, Follistatin) enabling dorsal ectoderm to adopt neural fate."
                        )
                    )
                ),
                keyDefinitions = listOf(
                    KeyDefinition("Grey Crescent", "Pigment-shifted dorsal cytoplasmic region opposite sperm entry point in amphibian eggs that specifies the future dorsal axis."),
                    KeyDefinition("Morphogen", "Diffusible signaling molecule (e.g., BMP4, Sonic Hedgehog, Bicoid) specifying distinct cell fates in a concentration-dependent gradient.")
                ),
                highYieldPoints = listOf(
                    "Default fate of amphibian ectoderm in the absence of BMP4 is Neural Tissue (neural induction by Chordin/Noggin).",
                    "Holoblastic unequal cleavage occurs in mesolecithal amphibian eggs; meroblastic discoidal cleavage occurs in telolecithal chick eggs."
                )
            )
        ),
        diagrams = listOf(
            BiologicalDiagram(
                id = "diag_frog_gastrulation",
                paperId = "sem6_dev_bio",
                title = "Amphibian Gastrulation & Spemann's Organizer",
                caption = "Sagittal cross-section showing blastopore dorsal lip, archenteron expansion, involution of chordamesoderm, and neural induction.",
                category = "Embryology Plate",
                vectorType = VectorDiagramType.FROG_GASTRULATION,
                labels = listOf(
                    DiagramLabel(1, "Ectoderm (Epiboly)", "Spreads downward to envelop embryo; dorsal ectoderm forms neural plate."),
                    DiagramLabel(2, "Dorsal Lip of Blastopore", "Spemann's Organizer secreting Chordin & Noggin (anti-BMP4)."),
                    DiagramLabel(3, "Involuting Chordamesoderm", "Rolls inward to form notochord and induce overlying neural tube."),
                    DiagramLabel(4, "Archenteron", "Expanding primitive gut cavity replacing the blastocoel."),
                    DiagramLabel(5, "Endodermal Yolk Plug", "Large yolky vegetal cells temporarily filling blastopore.")
                )
            )
        ),
        books = listOf(
            ReferenceBook(
                id = "book_gilbert_dev",
                paperId = "sem6_dev_bio",
                title = "Developmental Biology",
                authors = "Scott F. Gilbert & Michael J.F. Barresi",
                edition = "12th Edition (Sinauer/Oxford)",
                topicTag = "Fertilization, Gastrulation & Organizers",
                description = "Gold-standard embryology textbook explaining Spemann's organizer, morphogen gradients, and extra-embryonic membranes.",
                pdfUrl = "https://www.ncbi.nlm.nih.gov/books/NBK9983/"
            )
        ),
        pyqs = listOf(
            PreviousYearQuestion(
                id = "pyq_db_1",
                paperId = "sem6_dev_bio",
                year = "2024 Univ. Exam",
                marks = 5,
                question = "Describe Spemann and Mangold's organizer experiment and explain the molecular mechanism of neural induction.",
                modelAnswer = "Hilde Mangold and Hans Spemann transplanted the dorsal blastopore lip (organizer) of an early Triturus cristatus gastrula to the ventral region of a T. taeniatus host. The graft self-differentiated into notochord and induced host ventral cells to form a secondary neural tube and conjoined embryo. Molecularly, organizer cells secrete Chordin, Noggin, and Follistatin, which bind and neutralize ventralizing BMP4, allowing dorsal ectoderm to undergo neural differentiation.",
                examinerTip = "Mention both the classic grafting proof (two-toned embryos) and BMP4 antagonists."
            )
        ),
        quizChapters = listOf(
            QuizChapter(
                id = "quiz_db_ch1",
                paperId = "sem6_dev_bio",
                chapterTitle = "Fertilization, Cleavage & Induction",
                questions = listOf(
                    QuizQuestion(
                        id = "q_db_1",
                        question = "The slow block to polyspermy in sea urchin eggs is triggered by a cytosolic wave of:",
                        options = listOf("K+ efflux", "Ca2+ release triggering cortical granule exocytosis", "Cl- influx", "cAMP degradation"),
                        correctIndex = 1,
                        explanation = "IP3-mediated Ca2+ release from the ER triggers cortical granule fusion, lifting and cross-linking the fertilization envelope."
                    ),
                    QuizQuestion(
                        id = "q_db_2",
                        question = "Which secreted organizer proteins induce neural tube formation by antagonizing BMP4?",
                        options = listOf("Wnt & Notch", "Noggin & Chordin", "FGF & EGF", "Sonic Hedgehog & Hox"),
                        correctIndex = 1,
                        explanation = "Noggin, Chordin, and Follistatin bind BMP4 extracellularly, preventing epidermal induction so ectoderm defaults to neural fate."
                    )
                )
            )
        )
    )

    private fun evolutionPaper() = ZoologyPaper(
        id = "sem6_evolution",
        semester = 6,
        code = "ZOO-CC602",
        title = "Evolutionary Biology",
        shortDescription = "Origin of life, Neo-Darwinism, Hardy-Weinberg population genetics, genetic drift, speciation, and molecular clocks.",
        credits = 4,
        domainIcon = PaperDomainIcon.EVOLUTION,
        units = listOf(
            StudyUnit(
                id = "evo_u1",
                paperId = "sem6_evolution",
                unitNumber = 1,
                title = "Population Genetics, Hardy-Weinberg & Speciation",
                summary = "Allele vs genotype frequencies (p² + 2pq + q² = 1), microevolutionary forces, founder/bottleneck drift, and allopatric vs sympatric speciation.",
                sections = listOf(
                    NoteSection(
                        heading = "Hardy-Weinberg Equilibrium (1908)",
                        bulletPoints = listOf(
                            "p + q = 1 (allele frequencies); p² + 2pq + q² = 1 (genotype frequencies).",
                            "Five assumptions for zero evolution: Large population (no drift), random mating, no mutation, no migration (gene flow), and no natural selection.",
                            "Selection modes: Stabilizing (narrows variance, e.g., human birth weight), Directional (shifts mean, e.g., Biston betularia industrial melanism), Disruptive (favors both extremes)."
                        )
                    ),
                    NoteSection(
                        heading = "Modes of Speciation",
                        bulletPoints = listOf(
                            "Allopatric speciation: Geographic barrier (vicariance/dispersal) blocks gene flow (e.g., Darwin's finches).",
                            "Sympatric speciation: Reproductive isolation within the same geographic area via polyploidy or ecological niche shifts."
                        )
                    )
                ),
                keyDefinitions = listOf(
                    KeyDefinition("Genetic Drift", "Random fluctuation in allele frequencies across generations due to finite sampling error, strongest in small populations (Bottleneck & Founder effects)."),
                    KeyDefinition("Biological Species Concept", "Ernst Mayr's definition: groups of actually or potentially interbreeding natural populations reproductively isolated from other groups.")
                ),
                highYieldPoints = listOf(
                    "If 16% (q² = 0.16) of a Hardy-Weinberg population shows a recessive trait, then q = 0.4, p = 0.6, and heterozygous carriers (2pq) = 48%.",
                    "Miller-Urey (1953) simulated reducing atmosphere (CH4, NH3, H2, H2O vapor) with electric sparks, synthesizing amino acids like glycine and alanine."
                )
            )
        ),
        diagrams = listOf(
            BiologicalDiagram(
                id = "diag_hardy_weinberg",
                paperId = "sem6_evolution",
                title = "Hardy-Weinberg Curves & Modes of Selection",
                caption = "Parabolic genotype frequency distribution (p², 2pq, q²) alongside Stabilizing, Directional, and Disruptive selection shifts.",
                category = "Evolutionary Genetics Chart",
                vectorType = VectorDiagramType.HARDY_WEINBERG_EQUILIBRIUM,
                labels = listOf(
                    DiagramLabel(1, "Homozygous Dominant (p²)", "Peak = 1.0 when p = 1; drops quadratically as p declines."),
                    DiagramLabel(2, "Heterozygotes (2pq)", "Reaches maximum frequency of 0.50 when p = q = 0.5."),
                    DiagramLabel(3, "Homozygous Recessive (q²)", "Masks rare deleterious alleles inside 2pq carriers."),
                    DiagramLabel(4, "Stabilizing vs Disruptive Curves", "Single narrow peak vs bimodal divergence promoting speciation.")
                )
            )
        ),
        books = listOf(
            ReferenceBook(
                id = "book_futuyma_evo",
                paperId = "sem6_evolution",
                title = "Evolution",
                authors = "Douglas J. Futuyma & Mark Kirkpatrick",
                edition = "4th Edition (Sinauer)",
                topicTag = "Population Genetics & Speciation",
                description = "Comprehensive modern evolutionary synthesis covering Hardy-Weinberg math, neutral theory, and phylogenetics.",
                pdfUrl = "https://archive.org/search?query=Futuyma+Evolution"
            ),
            ReferenceBook(
                id = "book_strickberger",
                paperId = "sem6_evolution",
                title = "Strickberger's Evolution",
                authors = "Brian K. Hall & Benedikt Hallgrímsson",
                edition = "5th Edition",
                topicTag = "Origin of Life & Phylogeny",
                description = "Standard B.Sc. evolution reference for Miller-Urey, horse evolution, and isolating mechanisms.",
                pdfUrl = "https://archive.org/search?query=Strickberger+Evolution"
            )
        ),
        pyqs = listOf(
            PreviousYearQuestion(
                id = "pyq_evo_1",
                paperId = "sem6_evolution",
                year = "2024 Univ. Exam",
                marks = 5,
                question = "State the Hardy-Weinberg principle and calculate carrier frequency if 1 in 2,500 individuals exhibits an autosomal recessive disorder.",
                modelAnswer = "Hardy-Weinberg equilibrium states that allele and genotype frequencies remain constant across generations in an infinitely large, randomly mating population free of mutation, migration, and selection (p² + 2pq + q² = 1). Given q² = 1/2500 = 0.0004, recessive allele frequency q = √0.0004 = 0.02. Thus p = 1 - 0.02 = 0.98. Carrier frequency (2pq) = 2 × 0.98 × 0.02 = 0.0392 (3.92%, or ~1 in 25).",
                examinerTip = "Always take the square root of q² first to obtain q, then compute p = 1 - q before 2pq."
            )
        ),
        quizChapters = listOf(
            QuizChapter(
                id = "quiz_evo_ch1",
                paperId = "sem6_evolution",
                chapterTitle = "Population Genetics & Speciation",
                questions = listOf(
                    QuizQuestion(
                        id = "q_evo_1",
                        question = "In a population in Hardy-Weinberg equilibrium where 9% of individuals show a recessive phenotype, what percentage are heterozygous carriers?",
                        options = listOf("21%", "42%", "49%", "30%"),
                        correctIndex = 1,
                        explanation = "q² = 0.09 -> q = 0.3, so p = 0.7. Heterozygote carrier frequency = 2pq = 2(0.7)(0.3) = 0.42 (42%)."
                    ),
                    QuizQuestion(
                        id = "q_evo_2",
                        question = "Industrial melanism in Biston betularia is a classic textbook example of:",
                        options = listOf("Stabilizing selection", "Directional selection", "Disruptive selection", "Founder effect"),
                        correctIndex = 1,
                        explanation = "Soot-darkened tree bark shifted selective survival toward the carbonaria melanic morph, shifting the population mean in one direction."
                    )
                )
            )
        )
    )
}
