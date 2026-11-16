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

object Semesters3To4Data {
    val semester3 = SemesterInfo(
        semesterNumber = 3,
        title = "Semester 3",
        subtitle = "Chordate Diversity, Neuro-Endocrine Physiology & Biochemistry",
        papers = listOf(chordatesPaper(), physiologyControllingPaper(), biochemistryPaper())
    )

    val semester4 = SemesterInfo(
        semesterNumber = 4,
        title = "Semester 4",
        subtitle = "Comparative Anatomy, Systemic Physiology & Metabolism",
        papers = listOf(comparativeAnatomyPaper(), physiologyLifeSustainingPaper(), metabolismPaper())
    )

    private fun chordatesPaper() = ZoologyPaper(
        id = "sem3_chordates",
        semester = 3,
        code = "ZOO-CC301",
        title = "Diversity of Chordates",
        shortDescription = "Protochordates, retrogressive metamorphosis, fish migration, amphibian neoteny, snake poison apparatus, and avian flight adaptations.",
        credits = 4,
        domainIcon = PaperDomainIcon.CHORDATE,
        units = listOf(
            StudyUnit(
                id = "ch_u1",
                paperId = "sem3_chordates",
                unitNumber = 1,
                title = "Fundamental Chordate Plan & Protochordata",
                summary = "Four diagnostic chordate hallmarks, Herdmania tadpole retrogressive metamorphosis, and Branchiostoma (Amphioxus) filter feeding.",
                sections = listOf(
                    NoteSection(
                        heading = "Diagnostic Chordate Characters",
                        bulletPoints = listOf(
                            "Dorsal hollow tubular nerve cord (ectodermal) lying above the notochord.",
                            "Notochord: Flexible, vacuolated mesodermal axial rod.",
                            "Pharyngeal gill slits: Perforated pharynx initially evolved for filter feeding.",
                            "Post-anal muscular tail and ventral myogenic heart."
                        )
                    ),
                    NoteSection(
                        heading = "Retrogressive Metamorphosis in Herdmania",
                        bulletPoints = listOf(
                            "Free-swimming ascidian tadpole possesses advanced chordate traits: tail, notochord, dorsal nerve cord, ocellus, and otocyst.",
                            "Upon settlement by adhesive papillae, tail, notochord, and sensory organs degenerate while pharynx expands into a branchial sac with tunic."
                        )
                    )
                ),
                keyDefinitions = listOf(
                    KeyDefinition("Retrogressive Metamorphosis", "Developmental transformation where an active larva with advanced chordate features degenerates into a sessile, simplified adult."),
                    KeyDefinition("Wheel Organ", "Ciliated Müller's organ in Amphioxus oral hood generating feeding water currents.")
                ),
                highYieldPoints = listOf(
                    "Cephalochordata (Amphioxus) retain notochord from head to tail throughout life; Urochordata restrict it to the larval tail.",
                    "Endostyle of protochordates is homologous to the vertebrate thyroid gland."
                )
            ),
            StudyUnit(
                id = "ch_u2",
                paperId = "sem3_chordates",
                unitNumber = 2,
                title = "Vertebrate Adaptations: Pisces to Mammalia",
                summary = "Accessory respiratory organs in teleosts, paedomorphosis in Ambystoma, biting mechanism of snakes, and flight adaptations in birds.",
                sections = listOf(
                    NoteSection(
                        heading = "Pisces & Amphibia",
                        bulletPoints = listOf(
                            "Anadromous migration (sea -> freshwater for spawning, e.g., Salmon, Hilsa) vs Catadromous migration (freshwater -> sea, e.g., Anguilla).",
                            "Neoteny in Ambystoma (Axolotl larva): Retention of larval external gills into sexual maturity due to low thyroxine/iodine."
                        )
                    ),
                    NoteSection(
                        heading = "Reptilia, Aves & Mammalia",
                        bulletPoints = listOf(
                            "Poison apparatus in snakes: Modified parotid salivary glands, hollow/grooved maxillary fangs (Proteroglyphous in Cobra, Solenoglyphous in Viper).",
                            "Avian flight adaptations: Pneumatic bones, keeled sternum, syrinx, 9 air sacs for double respiration, single left ovary, and absence of urinary bladder."
                        )
                    )
                ),
                keyDefinitions = listOf(
                    KeyDefinition("Neoteny", "Retention of juvenile somatic traits in a sexually mature organism (paedomorphosis)."),
                    KeyDefinition("Solenoglyphous Fang", "Hinged, tubular anterior maxillary fang capable of folding back when the jaw closes (Viperidae).")
                ),
                highYieldPoints = listOf(
                    "Cobra venom is neurotoxic; Viper venom is predominantly haemotoxic/vasculotoxic.",
                    "Archaeopteryx is the connecting link showing reptilian teeth/clawed wings and avian feathers/furcula."
                )
            )
        ),
        diagrams = listOf(
            BiologicalDiagram(
                id = "diag_chordate_plan",
                paperId = "sem3_chordates",
                title = "Generalized Chordate Body Plan",
                caption = "Longitudinal anatomical blueprint showing the four primary diagnostic chordate characters and ventral heart.",
                category = "Chordate Taxonomy Plate",
                vectorType = VectorDiagramType.CHORDATE_CHARACTERS,
                labels = listOf(
                    DiagramLabel(1, "Dorsal Hollow Nerve Cord", "Fluid-filled neural tube differentiating into brain & spinal cord."),
                    DiagramLabel(2, "Notochord", "Elastic axial rod resisting longitudinal compression."),
                    DiagramLabel(3, "Pharyngeal Gill Slits", "Water exit slits supporting filter feeding or gill respiration."),
                    DiagramLabel(4, "Post-Anal Tail", "Muscular locomotor extension posterior to the anus."),
                    DiagramLabel(5, "Ventral Heart & Endostyle", "Circulatory pump and iodine-binding pharyngeal groove.")
                )
            )
        ),
        books = listOf(
            ReferenceBook(
                id = "book_kotpal_verts",
                paperId = "sem3_chordates",
                title = "Modern Text Book of Zoology: Vertebrates",
                authors = "R.L. Kotpal",
                edition = "4th Edition (Rastogi)",
                topicTag = "Protochordates to Mammals",
                description = "Standard B.Sc. reference for Herdmania, Amphioxus, Scoliodon, Columba, and vertebrate evolutionary adaptations.",
                pdfUrl = "https://archive.org/search?query=Modern+Text+Book+of+Zoology+Vertebrates+Kotpal"
            ),
            ReferenceBook(
                id = "book_jordan_chordate",
                paperId = "sem3_chordates",
                title = "Chordate Zoology",
                authors = "E.L. Jordan & P.S. Verma",
                edition = "Revised Edition (S. Chand)",
                topicTag = "Chordate Type Studies & Migration",
                description = "Detailed comparative tables on fish migration, snake dentition, and mammalian orders.",
                pdfUrl = "https://archive.org/search?query=Chordate+Zoology+Jordan+Verma"
            )
        ),
        pyqs = listOf(
            PreviousYearQuestion(
                id = "pyq_ch_1",
                paperId = "sem3_chordates",
                year = "2024 Univ. Exam",
                marks = 5,
                question = "Describe the biting mechanism of a poisonous snake with special reference to viperine fangs.",
                modelAnswer = "When a viper strikes, contraction of the digastric muscle opens the lower jaw while the sphenopterygoid pulls the pterygoid forward. This pushes the ectopterygoid against the rotatable maxilla, erecting the folded solenoglyphous fangs by 90 degrees. Temporal muscles simultaneously compress the venom gland, forcing venom through the duct into the hollow fang canal.",
                examinerTip = "Name the four key skull bones involved: quadrate, pterygoid, ectopterygoid, and maxilla."
            )
        ),
        quizChapters = listOf(
            QuizChapter(
                id = "quiz_ch_1",
                paperId = "sem3_chordates",
                chapterTitle = "Protochordates & Vertebrate Classes",
                questions = listOf(
                    QuizQuestion(
                        id = "q_ch_1",
                        question = "Which protochordate structure is homologous to the vertebrate thyroid gland?",
                        options = listOf("Hatschek's pit", "Endostyle", "Wheel organ", "Atriopore"),
                        correctIndex = 1,
                        explanation = "The ciliated iodine-concentrating endostyle of protochordates and ammocoete larvae transforms directly into the thyroid gland in adult lampreys and vertebrates."
                    ),
                    QuizQuestion(
                        id = "q_ch_2",
                        question = "Anguilla (freshwater eel) migrates to the Sargasso Sea for spawning. This is an example of:",
                        options = listOf("Anadromous migration", "Catadromous migration", "Amphidromous migration", "Potamodromous migration"),
                        correctIndex = 1,
                        explanation = "Catadromous fishes live in freshwater and migrate to marine waters to spawn; anadromous fishes (Salmon) do the reverse."
                    ),
                    QuizQuestion(
                        id = "q_ch_3",
                        question = "Which hormone induces metamorphosis in the neotenic Axolotl larva?",
                        options = listOf("Insulin", "Thyroxine", "Prolactin", "Melatonin"),
                        correctIndex = 1,
                        explanation = "Administering thyroxine (or iodine) triggers gill resorption and terrestrial metamorphosis in Ambystoma mexicanum."
                    )
                )
            )
        )
    )

    private fun physiologyControllingPaper() = ZoologyPaper(
        id = "sem3_phys_control",
        semester = 3,
        code = "ZOO-CC302",
        title = "Animal Physiology: Controlling Systems",
        shortDescription = "Resting & action potentials, synaptic transmission, sliding filament muscle mechanics, and hypothalamic-pituitary endocrinology.",
        credits = 4,
        domainIcon = PaperDomainIcon.NEURAL,
        units = listOf(
            StudyUnit(
                id = "pc_u1",
                paperId = "sem3_phys_control",
                unitNumber = 1,
                title = "Neurophysiology & Synaptic Transmission",
                summary = "Hodgkin-Huxley ionic basis of action potential, saltatory conduction in myelinated axons, and cholinergic chemical synapses.",
                sections = listOf(
                    NoteSection(
                        heading = "Action Potential Phases",
                        bulletPoints = listOf(
                            "Resting Membrane Potential (-70 mV) maintained by Na+/K+-ATPase and K+ leak channels.",
                            "Depolarization: Threshold (-55 mV) opens voltage-gated Na+ channels -> rapid Na+ influx (+35 mV overshoot).",
                            "Repolarization: Na+ channel inactivation + delayed voltage-gated K+ channel opening -> K+ efflux.",
                            "Saltatory conduction jumps between Nodes of Ranvier in Schwann/oligodendrocyte-myelinated fibers."
                        )
                    ),
                    NoteSection(
                        heading = "Muscle Contraction (Huxley's Sliding Filament Theory)",
                        bulletPoints = listOf(
                            "Motor neuron ACh triggers sarcoplasmic reticulum Ca2+ release.",
                            "Ca2+ binds Troponin-C, shifting Tropomyosin off actin's myosin-binding sites.",
                            "ATP hydrolysis cocks myosin heads; power stroke pulls thin actin filaments toward the M-line, shortening the H-zone and I-band while A-band stays constant."
                        )
                    )
                ),
                keyDefinitions = listOf(
                    KeyDefinition("Saltatory Conduction", "Rapid propagation of action potentials leaping from one Node of Ranvier to the next across myelinated internodes."),
                    KeyDefinition("Sarcomere", "Functional contractile unit of striated muscle bounded between two successive Z-lines.")
                ),
                highYieldPoints = listOf(
                    "During contraction: A-band length remains constant; I-band and H-zone shorten.",
                    "ATP binding (NOT hydrolysis) detaches the myosin head from actin; lack of ATP causes rigor mortis."
                )
            ),
            StudyUnit(
                id = "pc_u2",
                paperId = "sem3_phys_control",
                unitNumber = 2,
                title = "Endocrinology & Mechanism of Hormone Action",
                summary = "Hypothalamic-pituitary axis, peptide cAMP second-messenger cascade vs steroid nuclear receptor signaling.",
                sections = listOf(
                    NoteSection(
                        heading = "Signal Transduction Pathways",
                        bulletPoints = listOf(
                            "Water-soluble hormones (epinephrine, glucagon, TSH) bind GPCRs -> Gs protein activates Adenylyl Cyclase -> cAMP -> Protein Kinase A phosphorylation cascade.",
                            "Lipid-soluble hormones (cortisol, estrogen, thyroxine) cross the plasma membrane, bind intracellular/nuclear receptors, and alter gene transcription directly."
                        )
                    )
                ),
                keyDefinitions = listOf(
                    KeyDefinition("Second Messenger", "Intracellular signaling molecule (e.g., cAMP, IP3, DAG, Ca2+) amplifying extracellular hormone binding."),
                    KeyDefinition("Negative Feedback Loop", "Homeostatic mechanism where elevated target hormone suppresses upstream hypothalamic/pituitary secretion.")
                ),
                highYieldPoints = listOf(
                    "Posterior pituitary (neurohypophysis) stores and releases hypothalamic Oxytocin and ADH (Vasopressin) — it does not synthesize them.",
                    "Insulin lowers blood glucose via GLUT4 translocation; Glucagon raises it via hepatic glycogenolysis."
                )
            )
        ),
        diagrams = listOf(
            BiologicalDiagram(
                id = "diag_synapse_ap",
                paperId = "sem3_phys_control",
                title = "Action Potential Curve & Chemical Synapse",
                caption = "Biphasic ionic waveform (-70 mV to +35 mV) paired with Ca2+-triggered neurotransmitter exocytosis.",
                category = "Neurophysiology Chart",
                vectorType = VectorDiagramType.SYNAPSE_ACTION_POTENTIAL,
                labels = listOf(
                    DiagramLabel(1, "Resting Potential (-70 mV)", "Maintained by 3Na+/2K+ pump and K+ leak conductance."),
                    DiagramLabel(2, "Depolarization (+35 mV)", "Voltage-gated Na+ channel activation & rapid influx."),
                    DiagramLabel(3, "Repolarization & Hyperpolarization", "Na+ inactivation and delayed K+ efflux."),
                    DiagramLabel(4, "Presynaptic Ca2+ Influx", "Triggers SNARE-mediated ACh vesicle fusion."),
                    DiagramLabel(5, "Postsynaptic Nicotinic Receptor", "Ligand-gated cation channel generating EPSP.")
                )
            )
        ),
        books = listOf(
            ReferenceBook(
                id = "book_guyton_phys",
                paperId = "sem3_phys_control",
                title = "Guyton and Hall Textbook of Medical Physiology",
                authors = "John E. Hall & Michael E. Hall",
                edition = "14th Edition (Elsevier)",
                topicTag = "Neurophysiology, Muscle & Endocrinology",
                description = "Premier physiology reference for membrane potentials, sarcomere cross-bridge cycling, and endocrine feedback axes.",
                pdfUrl = "https://archive.org/search?query=Guyton+and+Hall+Textbook+of+Medical+Physiology"
            ),
            ReferenceBook(
                id = "book_chatterjee_phys",
                paperId = "sem3_phys_control",
                title = "Human Physiology (Vol. I & II)",
                authors = "C.C. Chatterjee",
                edition = "12th Edition",
                topicTag = "University Exam Physiology",
                description = "Structured Indian undergraduate physiology text ideal for concise short-answer and flow-chart preparation.",
                pdfUrl = "https://archive.org/search?query=C.C.+Chatterjee+Human+Physiology"
            )
        ),
        pyqs = listOf(
            PreviousYearQuestion(
                id = "pyq_pc_1",
                paperId = "sem3_phys_control",
                year = "2024 Univ. Exam",
                marks = 5,
                question = "Explain the molecular events during cross-bridge cycling in skeletal muscle contraction.",
                modelAnswer = "1. Arrival of action potential releases Ca2+ from sarcoplasmic reticulum via ryanodine receptors. 2. Ca2+ binds troponin-C, displacing tropomyosin from actin active sites. 3. Energized myosin head (ADP+Pi) binds actin, releasing Pi and executing the power stroke that slides actin inward. 4. Fresh ATP binding detaches myosin from actin; ATP hydrolysis re-cocks the myosin head.",
                examinerTip = "Explicitly distinguish the role of ATP in detachment vs hydrolysis in cocking."
            )
        ),
        quizChapters = listOf(
            QuizChapter(
                id = "quiz_pc_ch1",
                paperId = "sem3_phys_control",
                chapterTitle = "Nerve Impulse, Muscle & Hormones",
                questions = listOf(
                    QuizQuestion(
                        id = "q_pc_1",
                        question = "During maximal skeletal muscle contraction, which sarcomere band remains unchanged in length?",
                        options = listOf("I-band", "H-zone", "A-band", "Distance between Z-lines"),
                        correctIndex = 2,
                        explanation = "The A-band equals the length of thick myosin filaments, which do not shorten; thin filaments slide inward, narrowing the I-band and H-zone."
                    ),
                    QuizQuestion(
                        id = "q_pc_2",
                        question = "Which step directly causes the myosin head to detach from the actin filament?",
                        options = listOf("Ca2+ binding to troponin", "Binding of a new ATP molecule", "Release of inorganic phosphate", "Hydrolysis of ATP to ADP"),
                        correctIndex = 1,
                        explanation = "Binding of fresh ATP breaks the actomyosin rigor bond; subsequent ATP hydrolysis re-energizes the myosin head."
                    ),
                    QuizQuestion(
                        id = "q_pc_3",
                        question = "Steroid hormones such as cortisol primarily exert their effects by:",
                        options = listOf("Opening Na+ channels", "Activating adenylyl cyclase", "Binding nuclear receptors to modulate transcription", "Degrading cAMP"),
                        correctIndex = 2,
                        explanation = "Lipophilic steroid hormones diffuse across the plasma membrane and bind intracellular receptors that act as transcription factors."
                    )
                )
            )
        )
    )

    private fun biochemistryPaper() = ZoologyPaper(
        id = "sem3_biochem",
        semester = 3,
        code = "ZOO-CC303",
        title = "Fundamentals of Biochemistry",
        shortDescription = "Biomolecules, protein folding, Michaelis-Menten enzyme kinetics, and carbohydrate glycolysis & TCA cycle.",
        credits = 4,
        domainIcon = PaperDomainIcon.BIOCHEM,
        units = listOf(
            StudyUnit(
                id = "bc_u1",
                paperId = "sem3_biochem",
                unitNumber = 1,
                title = "Enzymology & Kinetics",
                summary = "Lock-and-key vs induced fit, Michaelis-Menten equation, Lineweaver-Burk double reciprocal plots, and competitive vs non-competitive inhibition.",
                sections = listOf(
                    NoteSection(
                        heading = "Enzyme Kinetics",
                        bulletPoints = listOf(
                            "Michaelis-Menten Equation: V0 = (Vmax [S]) / (Km + [S]).",
                            "Km is the substrate concentration at which reaction velocity is half-maximal (Vmax/2); inversely reflects enzyme affinity.",
                            "Competitive inhibitor binds active site: Vmax unchanged, apparent Km increases.",
                            "Non-competitive inhibitor binds allosteric site: Vmax decreases, Km unchanged."
                        )
                    )
                ),
                keyDefinitions = listOf(
                    KeyDefinition("Km (Michaelis Constant)", "Substrate concentration yielding 50% Vmax; lower Km indicates higher affinity for substrate."),
                    KeyDefinition("Isozymes", "Structurally distinct enzymatic variants catalyzing the same chemical reaction (e.g., LDH1–LDH5).")
                ),
                highYieldPoints = listOf(
                    "On a Lineweaver-Burk plot (1/V vs 1/[S]), Y-intercept = 1/Vmax and X-intercept = -1/Km.",
                    "Uncompetitive inhibitors decrease both Vmax and apparent Km equally (parallel Lineweaver-Burk lines)."
                )
            ),
            StudyUnit(
                id = "bc_u2",
                paperId = "sem3_biochem",
                unitNumber = 2,
                title = "Carbohydrate Metabolism: Glycolysis & Krebs Cycle",
                summary = "Embden-Meyerhof-Parnas cytosolic pathway, regulatory irreversible enzymes, and mitochondrial Citric Acid Cycle.",
                sections = listOf(
                    NoteSection(
                        heading = "Glycolysis (Cytosol) — 10 Steps",
                        bulletPoints = listOf(
                            "Irreversible pace-setting enzymes: Hexokinase, Phosphofructokinase-1 (PFK-1, committed step), and Pyruvate Kinase.",
                            "Net yield per glucose: 2 Pyruvate + 2 ATP + 2 NADH.",
                            "Under anaerobic conditions, Pyruvate reduces to Lactate via LDH regenerating NAD+."
                        )
                    ),
                    NoteSection(
                        heading = "TCA / Krebs Cycle (Mitochondrial Matrix)",
                        bulletPoints = listOf(
                            "Acetyl-CoA (2C) condenses with Oxaloacetate (4C) via Citrate Synthase to form Citrate (6C).",
                            "Per Acetyl-CoA turn: 3 NADH + 1 FADH2 + 1 GTP (substrate-level) + 2 CO2 released.",
                            "Succinate Dehydrogenase is the sole TCA enzyme embedded in the inner mitochondrial membrane (Complex II)."
                        )
                    )
                ),
                keyDefinitions = listOf(
                    KeyDefinition("Amphibolic Pathway", "Metabolic pathway functioning in both catabolism and anabolism (e.g., TCA cycle intermediates feed amino acid & heme synthesis)."),
                    KeyDefinition("Anaplerotic Reaction", "Reaction replenishing TCA intermediates, notably Pyruvate + CO2 -> Oxaloacetate via Pyruvate Carboxylase.")
                ),
                highYieldPoints = listOf(
                    "PFK-1 is strongly activated by Fructose-2,6-bisphosphate and AMP, and inhibited by ATP and Citrate.",
                    "Complete aerobic oxidation of 1 glucose yields ~30–32 ATP."
                )
            )
        ),
        diagrams = listOf(
            BiologicalDiagram(
                id = "diag_krebs",
                paperId = "sem3_biochem",
                title = "Krebs (TCA) Cycle & Bioenergetic Output",
                caption = "Circular metabolic flowchart highlighting all 8 enzymatic steps, decarboxylations, NADH/FADH2 yield, and GTP synthesis.",
                category = "Biochemistry Flowchart",
                vectorType = VectorDiagramType.KREBS_CYCLE_FLOWCHART,
                labels = listOf(
                    DiagramLabel(1, "Citrate Synthase (6C)", "Condenses Acetyl-CoA (2C) + Oxaloacetate (4C) -> Citrate."),
                    DiagramLabel(2, "Isocitrate Dehydrogenase", "First oxidative decarboxylation: yields NADH + CO2 -> α-KG (5C)."),
                    DiagramLabel(3, "α-Ketoglutarate DH", "Second decarboxylation: yields NADH + CO2 -> Succinyl-CoA (4C)."),
                    DiagramLabel(4, "Succinyl-CoA Synthetase", "Substrate-level phosphorylation generating 1 GTP."),
                    DiagramLabel(5, "Succinate & Malate DH", "Produce 1 FADH2 (Complex II) and final 1 NADH regenerating OAA.")
                )
            )
        ),
        books = listOf(
            ReferenceBook(
                id = "book_lehninger",
                paperId = "sem3_biochem",
                title = "Lehninger Principles of Biochemistry",
                authors = "David L. Nelson & Michael M. Cox",
                edition = "8th Edition (Macmillan)",
                topicTag = "Enzymology, Glycolysis & TCA Cycle",
                description = "World-leading undergraduate biochemistry textbook covering enzyme kinetics, thermodynamics, and central metabolic pathways.",
                pdfUrl = "https://archive.org/search?query=Lehninger+Principles+of+Biochemistry"
            ),
            ReferenceBook(
                id = "book_satyanarayana",
                paperId = "sem3_biochem",
                title = "Biochemistry",
                authors = "U. Satyanarayana & U. Chakrapani",
                edition = "6th Edition",
                topicTag = "Clinical & Exam Biochemistry",
                description = "Clear pathway flowcharts, ATP balance sheets, and clinical correlations tailored for B.Sc. and medical students.",
                pdfUrl = "https://archive.org/search?query=Satyanarayana+Biochemistry"
            )
        ),
        pyqs = listOf(
            PreviousYearQuestion(
                id = "pyq_bc_1",
                paperId = "sem3_biochem",
                year = "2024 Univ. Exam",
                marks = 5,
                question = "Differentiate between competitive and non-competitive enzyme inhibition with Lineweaver-Burk parameters.",
                modelAnswer = "In competitive inhibition, the inhibitor structurally resembles the substrate and binds reversibly to the active site. High [S] outcompetes the inhibitor, so Vmax remains unchanged while apparent Km increases. In non-competitive inhibition, the inhibitor binds an allosteric site regardless of substrate occupancy, lowering functional enzyme concentration: Vmax decreases while Km remains unchanged.",
                examinerTip = "Sketch the two intersecting double-reciprocal plots (Y-axis intersection for competitive; X-axis intersection for non-competitive)."
            )
        ),
        quizChapters = listOf(
            QuizChapter(
                id = "quiz_bc_ch1",
                paperId = "sem3_biochem",
                chapterTitle = "Enzymes, Glycolysis & TCA Cycle",
                questions = listOf(
                    QuizQuestion(
                        id = "q_bc_1",
                        question = "Which enzyme catalyzes the committed rate-limiting step of glycolysis?",
                        options = listOf("Hexokinase", "Phosphofructokinase-1 (PFK-1)", "Aldolase", "Enolase"),
                        correctIndex = 1,
                        explanation = "PFK-1 converts Fructose-6-phosphate to Fructose-1,6-bisphosphate and serves as the principal allosteric pacemaker of glycolysis."
                    ),
                    QuizQuestion(
                        id = "q_bc_2",
                        question = "In the presence of a purely competitive inhibitor, what happens to Vmax and apparent Km?",
                        options = listOf("Vmax decreases, Km unchanged", "Vmax unchanged, Km increases", "Both decrease", "Vmax increases, Km decreases"),
                        correctIndex = 1,
                        explanation = "Excess substrate can saturate the active site at Vmax, but a higher [S] (higher apparent Km) is required to reach half-maximal velocity."
                    ),
                    QuizQuestion(
                        id = "q_bc_3",
                        question = "Which TCA cycle enzyme is an integral membrane protein of the inner mitochondrial membrane?",
                        options = listOf("Citrate synthase", "Isocitrate dehydrogenase", "Succinate dehydrogenase", "Fumarase"),
                        correctIndex = 2,
                        explanation = "Succinate dehydrogenase doubles as Complex II of the electron transport chain inside the inner mitochondrial membrane."
                    )
                )
            )
        )
    )

    private fun comparativeAnatomyPaper() = ZoologyPaper(
        id = "sem4_comp_anatomy",
        semester = 4,
        code = "ZOO-CC401",
        title = "Comparative Anatomy of Vertebrates",
        shortDescription = "Integumentary derivatives, evolutionary modification of aortic arches, heart chambers, jaw suspension, and kidney succession.",
        credits = 4,
        domainIcon = PaperDomainIcon.ANATOMY,
        units = listOf(
            StudyUnit(
                id = "ca_u1",
                paperId = "sem4_comp_anatomy",
                unitNumber = 1,
                title = "Evolution of Aortic Arches & Vertebrate Heart",
                summary = "Transformation of the primitive 6-pair branchial aortic arch plan across Fishes, Amphibians, Reptiles, Birds, and Mammals.",
                sections = listOf(
                    NoteSection(
                        heading = "Modification of 6 Embryonic Aortic Arches",
                        bulletPoints = listOf(
                            "Arches I & II: Disappear in most tetrapods (contribute minor facial/stapedial vessels).",
                            "Arch III: Forms Common & Internal Carotid arteries supplying the head.",
                            "Arch IV: Becomes Systemic Arch — both left & right retained in Amphibia/Reptilia; ONLY Right in Birds; ONLY Left in Mammals.",
                            "Arch V: Absent in amniotes; Arch VI: Forms Pulmonary artery (+ Ductus arteriosus in embryos)."
                        )
                    ),
                    NoteSection(
                        heading = "Kidney Evolution (Archinephros)",
                        bulletPoints = listOf(
                            "Pronephros: Functional in larval fishes/amphibians (head kidney).",
                            "Mesonephros: Functional adult kidney in Fishes and Amphibians.",
                            "Metanephros: Definitive, high-pressure adult kidney of Reptiles, Birds, and Mammals with Loop of Henle."
                        )
                    )
                ),
                keyDefinitions = listOf(
                    KeyDefinition("Foramen of Panizza", "Inter-aortic aperture in crocodilians connecting left and right systemic arches at the heart base."),
                    KeyDefinition("Autostylic Jaw Suspension", "Upper jaw articulates directly with the cranium without hyomandibula support (lungfishes, tetrapods).")
                ),
                highYieldPoints = listOf(
                    "Birds retain ONLY the Right 4th aortic arch; Mammals retain ONLY the Left 4th aortic arch.",
                    "Fish possess a 2-chambered venous heart (single circulation); Amphibians 3-chambered; Mammals/Birds 4-chambered (double circulation)."
                )
            )
        ),
        diagrams = listOf(
            BiologicalDiagram(
                id = "diag_aortic_arches",
                paperId = "sem4_comp_anatomy",
                title = "Evolution of Vertebrate Aortic Arches (I–VI)",
                caption = "Comparative schematic illustrating persistence of 3rd (Carotid), 4th (Systemic), and 6th (Pulmonary) arches across classes.",
                category = "Comparative Anatomy Plate",
                vectorType = VectorDiagramType.VERTEBRATE_AORTIC_ARCHES,
                labels = listOf(
                    DiagramLabel(1, "Arches I & II", "Regress in tetrapods after embryonic pharyngeal remodeling."),
                    DiagramLabel(2, "Arch III (Carotid)", "Internal carotid supply to cranial region."),
                    DiagramLabel(3, "Arch IV (Systemic)", "Right persists in Aves; Left persists in Mammalia."),
                    DiagramLabel(4, "Arch V", "Lost in adult amniotes; retained briefly in urodeles."),
                    DiagramLabel(5, "Arch VI (Pulmonary)", "Supplies lungs; Ductus Botalli closes after birth.")
                )
            )
        ),
        books = listOf(
            ReferenceBook(
                id = "book_kardong",
                paperId = "sem4_comp_anatomy",
                title = "Vertebrates: Comparative Anatomy, Function, Evolution",
                authors = "Kenneth V. Kardong",
                edition = "8th Edition (McGraw-Hill)",
                topicTag = "Aortic Arches, Skulls & Kidneys",
                description = "Authoritative functional and evolutionary anatomy of vertebrate organ systems.",
                pdfUrl = "https://archive.org/search?query=Kardong+Vertebrates+Comparative+Anatomy"
            ),
            ReferenceBook(
                id = "book_kent",
                paperId = "sem4_comp_anatomy",
                title = "Comparative Anatomy of the Vertebrates",
                authors = "George C. Kent & Robert K. Carr",
                edition = "9th Edition",
                topicTag = "Integument, Heart & Urinogenital Tract",
                description = "Concise comparative illustrations of vertebrate hearts, aortic arches, and renal succession.",
                pdfUrl = "https://archive.org/search?query=Kent+Comparative+Anatomy+of+the+Vertebrates"
            )
        ),
        pyqs = listOf(
            PreviousYearQuestion(
                id = "pyq_ca_1",
                paperId = "sem4_comp_anatomy",
                year = "2023 Univ. Exam",
                marks = 5,
                question = "Compare the fate of the 4th and 6th embryonic aortic arches in Amphibians, Birds, and Mammals.",
                modelAnswer = "In Amphibians, both right and left 4th arches form paired systemic arches while the 6th forms pulmocutaneous arteries. In Birds, only the right 4th systemic arch persists (left degenerates), and the 6th forms pulmonary arteries. In Mammals, only the left 4th arch persists as the aortic arch (right becomes right subclavian), and the 6th forms pulmonary arteries.",
                examinerTip = "Use solid lines for persistent arches and dotted lines for degenerated embryonic arches."
            )
        ),
        quizChapters = listOf(
            QuizChapter(
                id = "quiz_ca_ch1",
                paperId = "sem4_comp_anatomy",
                chapterTitle = "Comparative Cardiovascular & Renal Systems",
                questions = listOf(
                    QuizQuestion(
                        id = "q_ca_1",
                        question = "Which systemic aortic arch (Arch IV) persists in adult Mammals?",
                        options = listOf("Right 4th arch only", "Left 4th arch only", "Both right and left 4th arches", "Right 3rd arch"),
                        correctIndex = 1,
                        explanation = "Mammals retain the left 4th aortic arch as the systemic arch, whereas birds retain the right 4th aortic arch."
                    ),
                    QuizQuestion(
                        id = "q_ca_2",
                        question = "The functional adult kidney of adult amphibians like Rana is:",
                        options = listOf("Pronephros", "Mesonephros", "Metanephros", "Holonephros"),
                        correctIndex = 1,
                        explanation = "Adult fishes and amphibians rely on a mesonephric (opisthonephric) kidney; amniotes develop a metanephros."
                    )
                )
            )
        )
    )

    private fun physiologyLifeSustainingPaper() = ZoologyPaper(
        id = "sem4_phys_life",
        semester = 4,
        code = "ZOO-CC402",
        title = "Animal Physiology: Life Sustaining Systems",
        shortDescription = "Gastrointestinal digestion, Bohr effect & O2 dissociation, nephron counter-current concentration, and cardiac cycle ECG.",
        credits = 4,
        domainIcon = PaperDomainIcon.PHYSIOLOGY,
        units = listOf(
            StudyUnit(
                id = "pl_u1",
                paperId = "sem4_phys_life",
                unitNumber = 1,
                title = "Renal Physiology & Counter-Current Multiplier",
                summary = "Ultrafiltration across glomerular slit diaphragms, selective PCT reabsorption, and urine concentration via Loop of Henle & vasa recta.",
                sections = listOf(
                    NoteSection(
                        heading = "Three Steps of Urine Formation",
                        bulletPoints = listOf(
                            "Glomerular Filtration (~125 mL/min GFR): Driven by Net Filtration Pressure (NFP = PG - PB - πG ≈ 10 mmHg).",
                            "Tubular Reabsorption: 65% of Na+, water, and 100% of glucose/amino acids reabsorbed in PCT.",
                            "Counter-Current Mechanism: Descending limb of Loop of Henle is water-permeable (aquaporin-1) and solute-impermeable; ascending thick limb actively pumps Na+/K+/2Cl- while remaining water-impermeable."
                        )
                    )
                ),
                keyDefinitions = listOf(
                    KeyDefinition("Bohr Effect", "Rightward shift of the oxygen-haemoglobin dissociation curve caused by elevated pCO2, H+ (low pH), 2,3-BPG, or temperature, promoting O2 unloading in active tissues."),
                    KeyDefinition("Juxtaglomerular Apparatus (JGA)", "Macula densa + JG cells releasing Renin upon low afferent arteriolar pressure or low NaCl delivery.")
                ),
                highYieldPoints = listOf(
                    "ADH (Vasopressin) inserts Aquaporin-2 channels into the apical membrane of collecting duct principal cells.",
                    "Cardiac ECG waves: P = atrial depolarization; QRS = ventricular depolarization; T = ventricular repolarization."
                )
            )
        ),
        diagrams = listOf(
            BiologicalDiagram(
                id = "diag_nephron",
                paperId = "sem4_phys_life",
                title = "Mammalian Nephron & Renal Counter-Current",
                caption = "Detailed anatomical plate showing Bowman's capsule, glomerulus, PCT, Loop of Henle, DCT, and collecting duct.",
                category = "Renal Physiology Plate",
                drawableResId = R.drawable.img_diagram_nephron,
                labels = listOf(
                    DiagramLabel(1, "Bowman's Capsule & Glomerulus", "Fenestrated endothelium + podocyte filtration slits producing ultrafiltrate."),
                    DiagramLabel(2, "Proximal Convoluted Tubule (PCT)", "Brush-border microvilli reabsorbing glucose, amino acids, and 65% NaCl."),
                    DiagramLabel(3, "Loop of Henle", "Generates medullary osmotic gradient (300 -> 1200 mOsm/L)."),
                    DiagramLabel(4, "Distal Convoluted Tubule (DCT)", "Fine-tunes Na+ (Aldosterone) and Ca2+ (PTH) balance."),
                    DiagramLabel(5, "Collecting Duct", "ADH-regulated water reabsorption via Aquaporin-2.")
                )
            ),
            BiologicalDiagram(
                id = "diag_cardiac_ecg",
                paperId = "sem4_phys_life",
                title = "Cardiac Conduction System & Normal ECG",
                caption = "Pacemaker pathway (SA Node -> AV Node -> Bundle of His -> Purkinje) aligned with P-QRS-T waveform.",
                category = "Cardiovascular Flowchart",
                vectorType = VectorDiagramType.CARDIAC_CONDUCTION,
                labels = listOf(
                    DiagramLabel(1, "SA Node (Pacemaker)", "Initiates spontaneous depolarization (~72 bpm) -> P wave."),
                    DiagramLabel(2, "AV Node Delay (0.1 s)", "Permits complete atrial emptying into ventricles (PR interval)."),
                    DiagramLabel(3, "Bundle of His & Purkinje Fibers", "Rapid ventricular spread -> sharp QRS complex."),
                    DiagramLabel(4, "T Wave", "Ventricular repolarization preceding diastole.")
                )
            )
        ),
        books = listOf(
            ReferenceBook(
                id = "book_guyton_renal",
                paperId = "sem4_phys_life",
                title = "Guyton and Hall Textbook of Medical Physiology (Renal & Cardiac)",
                authors = "John E. Hall",
                edition = "14th Edition",
                topicTag = "Nephron, Counter-Current & ECG",
                description = "Standard reference for GFR Starling forces, counter-current multiplier, Bohr/Haldane effects, and cardiac cycle Wiggers diagram.",
                pdfUrl = "https://archive.org/search?query=Guyton+and+Hall+Textbook+of+Medical+Physiology"
            ),
            ReferenceBook(
                id = "book_tortora",
                paperId = "sem4_phys_life",
                title = "Principles of Anatomy and Physiology",
                authors = "Gerard J. Tortora & Bryan Derrickson",
                edition = "16th Edition",
                topicTag = "Digestion, Respiration & Excretion",
                description = "Student-friendly diagrams and step-by-step physiological summaries for B.Sc. semesters.",
                pdfUrl = "https://archive.org/search?query=Tortora+Principles+of+Anatomy+and+Physiology"
            )
        ),
        pyqs = listOf(
            PreviousYearQuestion(
                id = "pyq_pl_1",
                paperId = "sem4_phys_life",
                year = "2024 Univ. Exam",
                marks = 5,
                question = "Explain the counter-current mechanism for concentrating urine in the mammalian kidney.",
                modelAnswer = "The Loop of Henle acts as a counter-current multiplier and the vasa recta as a counter-current exchanger. The thick ascending limb actively pumps Na+, K+, and 2Cl- into the medullary interstitium while being impermeable to water. Water leaves the permeable descending limb by osmosis, establishing a corticomedullary gradient from 300 to 1200 mOsm/L. ADH then opens Aquaporin-2 channels in the collecting duct to concentrate urine.",
                examinerTip = "Mention both the multiplier (Loop of Henle) and exchanger (Vasa recta) roles."
            )
        ),
        quizChapters = listOf(
            QuizChapter(
                id = "quiz_pl_ch1",
                paperId = "sem4_phys_life",
                chapterTitle = "Respiration, Circulation & Excretion",
                questions = listOf(
                    QuizQuestion(
                        id = "q_pl_1",
                        question = "Which part of the nephron is impermeable to water but actively transports NaCl outward?",
                        options = listOf("Descending limb of Loop of Henle", "Thick ascending limb of Loop of Henle", "Proximal convoluted tubule", "Glomerulus"),
                        correctIndex = 1,
                        explanation = "The thick ascending limb lacks aquaporins and uses the NKCC2 cotransporter to dilute tubular fluid and build medullary hyperosmolarity."
                    ),
                    QuizQuestion(
                        id = "q_pl_2",
                        question = "Which condition shifts the Oxygen-Haemoglobin dissociation curve to the RIGHT (Bohr effect)?",
                        options = listOf("High pH & low CO2", "Low pH, high CO2 & elevated 2,3-BPG", "Low temperature", "Fetal haemoglobin"),
                        correctIndex = 1,
                        explanation = "Metabolically active tissues generate CO2, H+, and heat, lowering Hb affinity for O2 and facilitating unloading."
                    )
                )
            )
        )
    )

    private fun metabolismPaper() = ZoologyPaper(
        id = "sem4_metabolism",
        semester = 4,
        code = "ZOO-CC403",
        title = "Metabolism & Clinical Biochemistry",
        shortDescription = "Mitochondrial electron transport chain, chemiosmotic ATP synthesis, beta-oxidation of palmitate, and the Urea Cycle.",
        credits = 4,
        domainIcon = PaperDomainIcon.METABOLISM,
        units = listOf(
            StudyUnit(
                id = "met_u1",
                paperId = "sem4_metabolism",
                unitNumber = 1,
                title = "Oxidative Phosphorylation, Beta-Oxidation & Urea Cycle",
                summary = "Chemiosmotic coupling (Peter Mitchell), fatty acid carnitine shuttle, and hepatic ammonia detoxification via the Ornithine Cycle.",
                sections = listOf(
                    NoteSection(
                        heading = "Electron Transport Chain & Chemiosmosis",
                        bulletPoints = listOf(
                            "Complexes I, III, and IV pump H+ across the inner membrane (4, 4, and 2 H+ per electron pair from NADH).",
                            "Cytochrome c shuttles electrons from Complex III to Complex IV (Cytochrome c oxidase); O2 is the terminal electron acceptor.",
                            "Inhibitors: Rotenone (Complex I), Antimycin A (Complex III), Cyanide/CO (Complex IV); Uncouplers like DNP/Thermogenin dissipate H+ gradient as heat."
                        )
                    ),
                    NoteSection(
                        heading = "Krebs-Henseleit Urea Cycle (Liver)",
                        bulletPoints = listOf(
                            "Occurs partially in mitochondria (steps 1–2: Carbamoyl Phosphate Synthetase I & Ornithine Transcarbamylase) and cytosol (steps 3–5).",
                            "Two nitrogens of urea derive from free NH4+ and Aspartate; carbon derives from HCO3-; consumes 3 ATP (4 high-energy bonds)."
                        )
                    )
                ),
                keyDefinitions = listOf(
                    KeyDefinition("Carnitine Shuttle", "Acyl-carnitine transport system moving long-chain fatty acyl-CoA across the impermeable inner mitochondrial membrane."),
                    KeyDefinition("Chemiosmotic Hypothesis", "Peter Mitchell's model stating that an electrochemical proton gradient (proton-motive force) drives F0-F1 ATP synthase.")
                ),
                highYieldPoints = listOf(
                    "Beta-oxidation of Palmitic acid (16C) runs 7 cycles producing 8 Acetyl-CoA, 7 NADH, and 7 FADH2 (~106 net ATP).",
                    "CPS-I (rate-limiting Urea cycle enzyme) is allosterically activated by N-acetylglutamate."
                )
            )
        ),
        diagrams = listOf(
            BiologicalDiagram(
                id = "diag_urea_cycle",
                paperId = "sem4_metabolism",
                title = "Urea (Ornithine) Cycle — Compartmental Flow",
                caption = "Hepatic nitrogen detoxification across mitochondrial matrix and hepatocyte cytosol.",
                category = "Metabolism Flowchart",
                vectorType = VectorDiagramType.UREA_CYCLE_FLOWCHART,
                labels = listOf(
                    DiagramLabel(1, "CPS-I (Mitochondria)", "NH4+ + HCO3- + 2ATP -> Carbamoyl Phosphate (activated by NAG)."),
                    DiagramLabel(2, "Ornithine Transcarbamylase", "Condenses Carbamoyl-P + Ornithine -> Citrulline (exported to cytosol)."),
                    DiagramLabel(3, "Argininosuccinate Synthetase", "Citrulline + Aspartate + ATP -> Argininosuccinate."),
                    DiagramLabel(4, "Argininosuccinase", "Cleaves into Fumarate (to TCA) + Arginine."),
                    DiagramLabel(5, "Arginase (Cytosol)", "Hydrolyzes Arginine -> Urea (excreted) + Ornithine (recycled).")
                )
            )
        ),
        books = listOf(
            ReferenceBook(
                id = "book_lehninger_metab",
                paperId = "sem4_metabolism",
                title = "Lehninger Principles of Biochemistry (Bioenergetics & Metabolism)",
                authors = "Nelson & Cox",
                edition = "8th Edition",
                topicTag = "ETC, Beta-Oxidation & Urea Cycle",
                description = "Comprehensive energy balance calculations and structural enzymology of oxidative phosphorylation.",
                pdfUrl = "https://archive.org/search?query=Lehninger+Principles+of+Biochemistry"
            )
        ),
        pyqs = listOf(
            PreviousYearQuestion(
                id = "pyq_met_1",
                paperId = "sem4_metabolism",
                year = "2024 Univ. Exam",
                marks = 5,
                question = "Calculate the net ATP yield from complete beta-oxidation of one molecule of Palmitic acid (C16).",
                modelAnswer = "Palmitate (16C) undergoes 7 beta-oxidation spirals yielding 8 Acetyl-CoA, 7 FADH2, and 7 NADH. Using standard yields (1 NADH = 2.5 ATP, 1 FADH2 = 1.5 ATP, 1 Acetyl-CoA = 10 ATP via TCA): 8×10 + 7×2.5 + 7×1.5 = 80 + 17.5 + 10.5 = 108 ATP. Subtracting 2 ATP equivalents used in initial fatty acid activation to Palmitoyl-CoA gives 106 net ATP.",
                examinerTip = "Always subtract 2 ATP equivalents (AMP + PPi) for Acyl-CoA synthetase activation."
            )
        ),
        quizChapters = listOf(
            QuizChapter(
                id = "quiz_met_ch1",
                paperId = "sem4_metabolism",
                chapterTitle = "Oxidative Phosphorylation & Nitrogen Metabolism",
                questions = listOf(
                    QuizQuestion(
                        id = "q_met_1",
                        question = "Which poison inhibits Complex IV (Cytochrome c oxidase) of the electron transport chain?",
                        options = listOf("Rotenone", "Antimycin A", "Cyanide (CN-)", "Oligomycin"),
                        correctIndex = 2,
                        explanation = "Cyanide and carbon monoxide bind heme a3-CuB of Complex IV, blocking O2 reduction; oligomycin blocks F0 proton channel."
                    ),
                    QuizQuestion(
                        id = "q_met_2",
                        question = "Which two amino acids/ions directly donate the two nitrogen atoms of Urea?",
                        options = listOf("Glutamine & Glycine", "Free NH4+ & Aspartate", "Alanine & Serine", "Lysine & Histidine"),
                        correctIndex = 1,
                        explanation = "One nitrogen enters via Carbamoyl Phosphate (from NH4+) and the second enters via Aspartate."
                    )
                )
            )
        )
    )
}
