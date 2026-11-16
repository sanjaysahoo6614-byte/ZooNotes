package com.example.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.sp
import com.example.data.model.VectorDiagramType
import kotlin.math.cos
import kotlin.math.sin

private val InkEmerald = Color(0xFF0B6E4F)
private val InkEmeraldSoft = Color(0xFFD1F2E4)
private val InkSage = Color(0xFF2D6A57)
private val InkSlate = Color(0xFF22332D)
private val InkAmber = Color(0xFFB27316)
private val InkAmberSoft = Color(0xFFFCEBC8)
private val InkCoral = Color(0xFFC0483B)
private val InkTeal = Color(0xFF147D8B)

@Composable
fun VectorDiagramCanvas(
    vectorType: VectorDiagramType,
    modifier: Modifier = Modifier
) {
    val textMeasurer = rememberTextMeasurer()

    Canvas(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        drawSubtleGrid()
        when (vectorType) {
            VectorDiagramType.SYCON_CANAL_SYSTEM -> drawSyconCanal(textMeasurer)
            VectorDiagramType.ENERGY_PYRAMID_FOOD_WEB -> drawEnergyPyramid(textMeasurer)
            VectorDiagramType.WATER_VASCULAR_SYSTEM -> drawWaterVascular(textMeasurer)
            VectorDiagramType.CELL_CYCLE_MITOSIS -> drawCellCycle(textMeasurer)
            VectorDiagramType.CHORDATE_CHARACTERS -> drawChordatePlan(textMeasurer)
            VectorDiagramType.SYNAPSE_ACTION_POTENTIAL -> drawActionPotential(textMeasurer)
            VectorDiagramType.KREBS_CYCLE_FLOWCHART -> drawCycleDiagram(
                textMeasurer = textMeasurer,
                centerTitle = "KREBS\nCYCLE\n(Matrix)",
                nodes = listOf(
                    "1. Citrate (6C)" to InkEmerald,
                    "Isocitrate" to InkSage,
                    "2. α-KG (5C) + NADH" to InkTeal,
                    "3. Succinyl-CoA + NADH" to InkTeal,
                    "4. Succinate + GTP" to InkAmber,
                    "5. Fumarate + FADH₂" to InkCoral,
                    "Malate" to InkSage,
                    "OAA (4C) + NADH" to InkEmerald
                )
            )
            VectorDiagramType.VERTEBRATE_AORTIC_ARCHES -> drawAorticArches(textMeasurer)
            VectorDiagramType.CARDIAC_CONDUCTION -> drawCardiacEcg(textMeasurer)
            VectorDiagramType.UREA_CYCLE_FLOWCHART -> drawCycleDiagram(
                textMeasurer = textMeasurer,
                centerTitle = "UREA\nCYCLE\n(Liver)",
                nodes = listOf(
                    "1. Carbamoyl-P (Mito)" to InkEmerald,
                    "2. Citrulline" to InkTeal,
                    "3. Argininosuccinate" to InkAmber,
                    "4. Arginine + Fumarate" to InkSage,
                    "5. Urea + Ornithine" to InkCoral
                )
            )
            VectorDiagramType.LAC_OPERON_REGULATION -> drawLacOperon(textMeasurer)
            VectorDiagramType.DROSOPHILA_SEX_DETERMINATION -> drawDrosophilaMatrix(textMeasurer)
            VectorDiagramType.FROG_GASTRULATION -> drawFrogGastrulation(textMeasurer)
            VectorDiagramType.HARDY_WEINBERG_EQUILIBRIUM -> drawHardyWeinberg(textMeasurer)
        }
    }
}

private fun DrawScope.drawSubtleGrid() {
    val step = size.minDimension / 12f
    val gridColor = Color(0xFFEAF2EE)
    var x = step
    while (x < size.width) {
        drawLine(gridColor, Offset(x, 0f), Offset(x, size.height), strokeWidth = 1f)
        x += step
    }
    var y = step
    while (y < size.height) {
        drawLine(gridColor, Offset(0f, y), Offset(size.width, y), strokeWidth = 1f)
        y += step
    }
}

private fun DrawScope.labelBox(
    textMeasurer: TextMeasurer,
    text: String,
    topLeft: Offset,
    boxSize: Size,
    fill: Color,
    border: Color,
    textColor: Color = InkSlate,
    fontScale: Float = 1f
) {
    drawRoundRect(
        color = fill,
        topLeft = topLeft,
        size = boxSize,
        cornerRadius = CornerRadius(12f, 12f)
    )
    drawRoundRect(
        color = border,
        topLeft = topLeft,
        size = boxSize,
        cornerRadius = CornerRadius(12f, 12f),
        style = Stroke(width = 2.5f)
    )
    val fontSize = (size.minDimension * 0.036f * fontScale).coerceIn(8f, 16f).sp
    val layout = textMeasurer.measure(
        text = text,
        style = TextStyle(color = textColor, fontSize = fontSize, fontWeight = FontWeight.SemiBold)
    )
    drawText(
        textLayoutResult = layout,
        topLeft = Offset(
            topLeft.x + (boxSize.width - layout.size.width) / 2f,
            topLeft.y + (boxSize.height - layout.size.height) / 2f
        )
    )
}

private fun DrawScope.drawArrow(start: Offset, end: Offset, color: Color = InkEmerald) {
    drawLine(color = color, start = start, end = end, strokeWidth = 3.5f, cap = StrokeCap.Round)
    val angle = kotlin.math.atan2(end.y - start.y, end.x - start.x)
    val headLen = size.minDimension * 0.03f
    val p1 = Offset(
        end.x - headLen * cos(angle - 0.5f),
        end.y - headLen * sin(angle - 0.5f)
    )
    val p2 = Offset(
        end.x - headLen * cos(angle + 0.5f),
        end.y - headLen * sin(angle + 0.5f)
    )
    drawLine(color = color, start = end, end = p1, strokeWidth = 3.5f, cap = StrokeCap.Round)
    drawLine(color = color, start = end, end = p2, strokeWidth = 3.5f, cap = StrokeCap.Round)
}

private fun DrawScope.drawSyconCanal(tm: TextMeasurer) {
    val w = size.width
    val h = size.height
    val stages = listOf(
        "1. Dermal Ostia" to InkEmeraldSoft,
        "2. Incurrent Canal" to Color(0xFFE6F4F1),
        "3. Prosopyle Pore" to InkAmberSoft,
        "4. Radial Canal (Choanocytes)" to InkEmeraldSoft,
        "5. Apopyle -> Spongocoel -> Osculum" to Color(0xFFE1ECE7)
    )
    val boxW = w * 0.72f
    val boxH = h * 0.125f
    val startX = (w - boxW) / 2f
    stages.forEachIndexed { idx, (label, bg) ->
        val y = h * (0.07f + idx * 0.175f)
        labelBox(tm, label, Offset(startX, y), Size(boxW, boxH), bg, InkEmerald)
        if (idx < stages.lastIndex) {
            drawArrow(Offset(w / 2f, y + boxH + 4f), Offset(w / 2f, y + h * 0.175f - 4f), InkEmerald)
        }
    }
}

private fun DrawScope.drawEnergyPyramid(tm: TextMeasurer) {
    val w = size.width
    val h = size.height
    val tiers = listOf(
        Triple("4. Apex Predators (10 kcal)", 0.24f, InkCoral.copy(alpha = 0.20f)),
        Triple("3. Secondary Consumers (100 kcal)", 0.42f, InkAmberSoft),
        Triple("2. Primary Consumers (1,000 kcal)", 0.62f, Color(0xFFDCEEE7)),
        Triple("1. Producers (10,000 kcal)", 0.82f, InkEmeraldSoft)
    )
    val tierH = h * 0.16f
    tiers.forEachIndexed { i, (label, widthFrac, fill) ->
        val boxW = w * widthFrac
        val x = (w - boxW) / 2f
        val y = h * (0.10f + i * 0.185f)
        labelBox(tm, label, Offset(x, y), Size(boxW, tierH), fill, InkEmerald, fontScale = 0.92f)
    }
    labelBox(
        tm,
        "5. 10% Assimilation / 90% Heat Loss per Trophic Level",
        Offset(w * 0.09f, h * 0.86f),
        Size(w * 0.82f, h * 0.09f),
        Color.White,
        InkAmber,
        InkAmber,
        fontScale = 0.86f
    )
}

private fun DrawScope.drawWaterVascular(tm: TextMeasurer) {
    val w = size.width
    val h = size.height
    val cx = w * 0.5f
    val cy = h * 0.52f
    val ringR = size.minDimension * 0.16f

    drawCircle(InkEmeraldSoft, radius = ringR, center = Offset(cx, cy))
    drawCircle(InkEmerald, radius = ringR, center = Offset(cx, cy), style = Stroke(width = 6f))

    // 5 Radial Canals
    for (i in 0 until 5) {
        val angle = Math.toRadians((-90 + i * 72).toDouble()).toFloat()
        val start = Offset(cx + ringR * cos(angle), cy + ringR * sin(angle))
        val end = Offset(cx + ringR * 2.35f * cos(angle), cy + ringR * 2.35f * sin(angle))
        drawArrow(start, end, InkEmerald)
        // Tube feet ticks
        val mid = Offset((start.x + end.x) / 2f, (start.y + end.y) / 2f)
        drawCircle(InkAmber, radius = 7f, center = mid)
    }

    labelBox(tm, "1. Madreporite", Offset(w * 0.06f, h * 0.07f), Size(w * 0.30f, h * 0.11f), InkAmberSoft, InkAmber)
    drawArrow(Offset(w * 0.36f, h * 0.15f), Offset(cx - ringR * 0.5f, cy - ringR * 0.7f), InkAmber)
    labelBox(tm, "3. Ring Canal", Offset(cx - w * 0.14f, cy - h * 0.05f), Size(w * 0.28f, h * 0.10f), Color.White, InkEmerald, fontScale = 0.85f)
    labelBox(tm, "4. Radial Canals", Offset(w * 0.64f, h * 0.10f), Size(w * 0.31f, h * 0.11f), InkEmeraldSoft, InkEmerald, fontScale = 0.85f)
    labelBox(tm, "5. Ampulla & Tube Foot", Offset(w * 0.58f, h * 0.83f), Size(w * 0.37f, h * 0.11f), InkEmeraldSoft, InkEmerald, fontScale = 0.85f)
}

private fun DrawScope.drawCellCycle(tm: TextMeasurer) {
    val w = size.width
    val h = size.height
    val cx = w * 0.5f
    val cy = h * 0.5f
    val r = size.minDimension * 0.34f

    val segments = listOf(
        Triple(-90f, 120f, InkEmerald),
        Triple(30f, 100f, InkTeal),
        Triple(130f, 75f, InkAmber),
        Triple(205f, 65f, InkCoral)
    )
    segments.forEach { (startAngle, sweep, color) ->
        drawArc(
            color = color,
            startAngle = startAngle,
            sweepAngle = sweep - 6f,
            useCenter = false,
            topLeft = Offset(cx - r, cy - r),
            size = Size(r * 2, r * 2),
            style = Stroke(width = size.minDimension * 0.07f, cap = StrokeCap.Round)
        )
    }

    labelBox(tm, "1. G1 Phase", Offset(w * 0.68f, h * 0.18f), Size(w * 0.26f, h * 0.11f), InkEmeraldSoft, InkEmerald)
    labelBox(tm, "3. S Phase\n(DNA Rep)", Offset(w * 0.64f, h * 0.73f), Size(w * 0.29f, h * 0.14f), Color(0xFFE0F4F7), InkTeal)
    labelBox(tm, "4. G2 / MPF", Offset(w * 0.06f, h * 0.67f), Size(w * 0.27f, h * 0.11f), InkAmberSoft, InkAmber)
    labelBox(tm, "5. M Phase", Offset(w * 0.08f, h * 0.18f), Size(w * 0.25f, h * 0.11f), Color(0xFFFBE6E4), InkCoral)
    labelBox(tm, "2. G1/S\nCheckpoints", Offset(cx - w * 0.16f, cy - h * 0.08f), Size(w * 0.32f, h * 0.16f), Color.White, InkEmerald, fontScale = 0.85f)
}

private fun DrawScope.drawChordatePlan(tm: TextMeasurer) {
    val w = size.width
    val h = size.height
    // Stylized fish/chordate body outline
    val bodyPath = Path().apply {
        moveTo(w * 0.12f, h * 0.48f)
        quadraticTo(w * 0.35f, h * 0.20f, w * 0.75f, h * 0.38f)
        lineTo(w * 0.90f, h * 0.30f)
        lineTo(w * 0.86f, h * 0.48f)
        lineTo(w * 0.90f, h * 0.66f)
        lineTo(w * 0.75f, h * 0.58f)
        quadraticTo(w * 0.35f, h * 0.76f, w * 0.12f, h * 0.48f)
        close()
    }
    drawPath(bodyPath, InkEmeraldSoft.copy(alpha = 0.65f))
    drawPath(bodyPath, InkEmerald, style = Stroke(width = 4f))

    // 1. Dorsal nerve cord
    drawLine(InkTeal, Offset(w * 0.18f, h * 0.38f), Offset(w * 0.78f, h * 0.43f), strokeWidth = 7f, cap = StrokeCap.Round)
    // 2. Notochord
    drawLine(InkAmber, Offset(w * 0.20f, h * 0.44f), Offset(w * 0.82f, h * 0.48f), strokeWidth = 10f, cap = StrokeCap.Round)
    // 3. Gill slits
    for (i in 0..3) {
        val gx = w * (0.25f + i * 0.035f)
        drawLine(InkSlate, Offset(gx, h * 0.49f), Offset(gx, h * 0.59f), strokeWidth = 4f, cap = StrokeCap.Round)
    }
    // 5. Ventral heart
    drawCircle(InkCoral, radius = size.minDimension * 0.04f, center = Offset(w * 0.32f, h * 0.62f))

    labelBox(tm, "1. Dorsal Nerve Cord", Offset(w * 0.24f, h * 0.08f), Size(w * 0.40f, h * 0.10f), Color(0xFFE0F4F7), InkTeal, fontScale = 0.85f)
    labelBox(tm, "2. Notochord", Offset(w * 0.60f, h * 0.20f), Size(w * 0.30f, h * 0.10f), InkAmberSoft, InkAmber, fontScale = 0.85f)
    labelBox(tm, "3. Pharyngeal Gill Slits", Offset(w * 0.05f, h * 0.74f), Size(w * 0.38f, h * 0.10f), Color.White, InkSlate, fontScale = 0.82f)
    labelBox(tm, "4. Post-Anal Tail", Offset(w * 0.62f, h * 0.74f), Size(w * 0.32f, h * 0.10f), InkEmeraldSoft, InkEmerald, fontScale = 0.85f)
    labelBox(tm, "5. Ventral Heart", Offset(w * 0.24f, h * 0.87f), Size(w * 0.32f, h * 0.09f), Color(0xFFFBE6E4), InkCoral, fontScale = 0.82f)
}

private fun DrawScope.drawActionPotential(tm: TextMeasurer) {
    val w = size.width
    val h = size.height
    val baseY = h * 0.68f
    // Threshold dashed line
    drawLine(
        InkAmber,
        Offset(w * 0.08f, h * 0.56f),
        Offset(w * 0.92f, h * 0.56f),
        strokeWidth = 2.5f,
        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 8f))
    )
    // AP Curve
    val ap = Path().apply {
        moveTo(w * 0.08f, baseY)
        lineTo(w * 0.24f, baseY)
        cubicTo(w * 0.30f, h * 0.58f, w * 0.38f, h * 0.16f, w * 0.43f, h * 0.16f)
        cubicTo(w * 0.49f, h * 0.16f, w * 0.57f, h * 0.82f, w * 0.64f, h * 0.80f)
        cubicTo(w * 0.70f, h * 0.78f, w * 0.76f, baseY, w * 0.92f, baseY)
    }
    drawPath(ap, InkEmerald, style = Stroke(width = 6f, cap = StrokeCap.Round))

    labelBox(tm, "2. +35 mV\nNa+ Influx", Offset(w * 0.31f, h * 0.05f), Size(w * 0.26f, h * 0.14f), InkEmeraldSoft, InkEmerald, fontScale = 0.85f)
    labelBox(tm, "1. -70 mV Resting", Offset(w * 0.06f, h * 0.74f), Size(w * 0.28f, h * 0.10f), Color.White, InkSlate, fontScale = 0.82f)
    labelBox(tm, "3. K+ Efflux Repolarization", Offset(w * 0.56f, h * 0.36f), Size(w * 0.38f, h * 0.11f), InkAmberSoft, InkAmber, fontScale = 0.82f)
    labelBox(tm, "4–5. Presynaptic Ca2+ -> ACh Synapse", Offset(w * 0.40f, h * 0.85f), Size(w * 0.54f, h * 0.10f), Color(0xFFE0F4F7), InkTeal, fontScale = 0.82f)
}

private fun DrawScope.drawCycleDiagram(
    textMeasurer: TextMeasurer,
    centerTitle: String,
    nodes: List<Pair<String, Color>>
) {
    val w = size.width
    val h = size.height
    val cx = w * 0.5f
    val cy = h * 0.5f
    val r = size.minDimension * 0.33f

    drawCircle(InkEmeraldSoft.copy(alpha = 0.45f), radius = r, center = Offset(cx, cy), style = Stroke(width = 16f))
    labelBox(
        textMeasurer,
        centerTitle,
        Offset(cx - w * 0.15f, cy - h * 0.11f),
        Size(w * 0.30f, h * 0.22f),
        Color.White,
        InkEmerald,
        fontScale = 0.9f
    )

    val boxW = w * 0.30f
    val boxH = h * 0.10f
    nodes.forEachIndexed { idx, (label, border) ->
        val angle = (-90f + idx * (360f / nodes.size)) * Math.PI / 180.0
        val nx = (cx + r * cos(angle)).toFloat().coerceIn(boxW / 2f + 8f, w - boxW / 2f - 8f)
        val ny = (cy + r * sin(angle)).toFloat().coerceIn(boxH / 2f + 8f, h - boxH / 2f - 8f)
        labelBox(
            textMeasurer,
            label,
            Offset(nx - boxW / 2f, ny - boxH / 2f),
            Size(boxW, boxH),
            Color.White,
            border,
            fontScale = 0.76f
        )
    }
}

private fun DrawScope.drawAorticArches(tm: TextMeasurer) {
    val w = size.width
    val h = size.height
    // Dorsal & Ventral Aortae
    drawLine(InkEmerald, Offset(w * 0.14f, h * 0.18f), Offset(w * 0.86f, h * 0.18f), strokeWidth = 6f)
    drawLine(InkCoral, Offset(w * 0.14f, h * 0.72f), Offset(w * 0.86f, h * 0.72f), strokeWidth = 6f)

    val archNames = listOf("I", "II", "III\nCarotid", "IV\nSystemic", "V", "VI\nPulm")
    archNames.forEachIndexed { i, title ->
        val x = w * (0.18f + i * 0.128f)
        val active = i == 2 || i == 3 || i == 5
        val color = when (i) {
            2 -> InkTeal
            3 -> InkEmerald
            5 -> InkAmber
            else -> Color(0xFFB5C4BD)
        }
        drawLine(
            color = color,
            start = Offset(x, h * 0.72f),
            end = Offset(x, h * 0.18f),
            strokeWidth = if (active) 7f else 3f,
            pathEffect = if (active) null else PathEffect.dashPathEffect(floatArrayOf(8f, 8f))
        )
        labelBox(
            tm,
            title,
            Offset(x - w * 0.055f, h * 0.39f),
            Size(w * 0.11f, h * 0.15f),
            Color.White,
            color,
            fontScale = 0.75f
        )
    }
    labelBox(tm, "Birds: Right IV Only  |  Mammals: Left IV Only", Offset(w * 0.12f, h * 0.83f), Size(w * 0.76f, h * 0.10f), InkEmeraldSoft, InkEmerald, fontScale = 0.85f)
}

private fun DrawScope.drawCardiacEcg(tm: TextMeasurer) {
    val w = size.width
    val h = size.height
    val baseY = h * 0.56f
    val ecg = Path().apply {
        moveTo(w * 0.06f, baseY)
        lineTo(w * 0.18f, baseY)
        quadraticTo(w * 0.23f, h * 0.42f, w * 0.28f, baseY) // P
        lineTo(w * 0.36f, baseY)
        lineTo(w * 0.40f, h * 0.65f) // Q
        lineTo(w * 0.46f, h * 0.16f) // R
        lineTo(w * 0.52f, h * 0.72f) // S
        lineTo(w * 0.58f, baseY)
        lineTo(w * 0.66f, baseY)
        quadraticTo(w * 0.74f, h * 0.36f, w * 0.82f, baseY) // T
        lineTo(w * 0.94f, baseY)
    }
    drawPath(ecg, InkEmerald, style = Stroke(width = 6f, cap = StrokeCap.Round))
    labelBox(tm, "1. P Wave (SA)", Offset(w * 0.10f, h * 0.26f), Size(w * 0.24f, h * 0.10f), InkEmeraldSoft, InkEmerald, fontScale = 0.8f)
    labelBox(tm, "3. QRS (His-Purkinje)", Offset(w * 0.52f, h * 0.14f), Size(w * 0.34f, h * 0.10f), InkAmberSoft, InkAmber, fontScale = 0.8f)
    labelBox(tm, "4. T Wave (Repolarize)", Offset(w * 0.62f, h * 0.76f), Size(w * 0.33f, h * 0.10f), Color(0xFFE0F4F7), InkTeal, fontScale = 0.8f)
}

private fun DrawScope.drawLacOperon(tm: TextMeasurer) {
    val w = size.width
    val h = size.height
    drawLine(InkSlate, Offset(w * 0.06f, h * 0.52f), Offset(w * 0.94f, h * 0.52f), strokeWidth = 6f)
    val segments = listOf(
        Triple("1. lacI", 0.06f, 0.14f) to InkAmberSoft,
        Triple("2. CAP+P", 0.24f, 0.18f) to Color(0xFFE0F4F7),
        Triple("3. O", 0.44f, 0.10f) to Color(0xFFFBE6E4),
        Triple("4. lacZ", 0.56f, 0.13f) to InkEmeraldSoft,
        Triple("lacY", 0.70f, 0.11f) to InkEmeraldSoft,
        Triple("lacA", 0.82f, 0.11f) to InkEmeraldSoft
    )
    segments.forEach { (spec, bg) ->
        val (text, xf, wf) = spec
        labelBox(tm, text, Offset(w * xf, h * 0.45f), Size(w * wf, h * 0.14f), bg, InkEmerald, fontScale = 0.82f)
    }
    labelBox(tm, "Allolactose inactivates lacI  +  cAMP-CAP boosts Pol", Offset(w * 0.10f, h * 0.15f), Size(w * 0.80f, h * 0.12f), InkEmeraldSoft, InkEmerald, fontScale = 0.86f)
    labelBox(tm, "Polycistronic mRNA -> β-Gal, Permease, Transacetylase", Offset(w * 0.14f, h * 0.74f), Size(w * 0.76f, h * 0.12f), Color.White, InkTeal, fontScale = 0.84f)
}

private fun DrawScope.drawDrosophilaMatrix(tm: TextMeasurer) {
    val w = size.width
    val h = size.height
    val rows = listOf(
        Triple("1. 3X : 2A  (Ratio 1.50)", "Metafemale (Sterile)", InkAmberSoft),
        Triple("2. 2X : 2A / XXY (1.00)", "Normal Fertile Female", InkEmeraldSoft),
        Triple("3. 2X : 3A  (Ratio 0.67)", "Intersex Mosaic", Color(0xFFE0F4F7)),
        Triple("4. XY / XO : 2A (0.50)", "Male (XO Sterile)", Color(0xFFE7F0EC)),
        Triple("5. 1X : 3A  (Ratio 0.33)", "Metamale (Sterile)", Color(0xFFFBE6E4))
    )
    rows.forEachIndexed { idx, (left, right, fill) ->
        val y = h * (0.09f + idx * 0.17f)
        labelBox(tm, left, Offset(w * 0.06f, y), Size(w * 0.44f, h * 0.125f), Color.White, InkEmerald, fontScale = 0.80f)
        labelBox(tm, right, Offset(w * 0.53f, y), Size(w * 0.41f, h * 0.125f), fill, InkSage, fontScale = 0.80f)
    }
}

private fun DrawScope.drawFrogGastrulation(tm: TextMeasurer) {
    val w = size.width
    val h = size.height
    val cx = w * 0.48f
    val cy = h * 0.52f
    val r = size.minDimension * 0.33f
    drawCircle(InkEmeraldSoft, radius = r, center = Offset(cx, cy))
    drawCircle(InkEmerald, radius = r, center = Offset(cx, cy), style = Stroke(width = 5f))
    // Archenteron cavity
    drawOval(Color.White, topLeft = Offset(cx - r * 0.55f, cy - r * 0.42f), size = Size(r * 1.15f, r * 0.7f))
    drawOval(InkAmber, topLeft = Offset(cx - r * 0.55f, cy - r * 0.42f), size = Size(r * 1.15f, r * 0.7f), style = Stroke(width = 4f))

    labelBox(tm, "1. Ectoderm (Epiboly)", Offset(w * 0.06f, h * 0.08f), Size(w * 0.38f, h * 0.10f), InkEmeraldSoft, InkEmerald, fontScale = 0.82f)
    labelBox(tm, "2. Dorsal Lip (Organizer)", Offset(w * 0.54f, h * 0.08f), Size(w * 0.40f, h * 0.10f), InkAmberSoft, InkAmber, fontScale = 0.82f)
    labelBox(tm, "4. Archenteron", Offset(cx - w * 0.15f, cy - h * 0.06f), Size(w * 0.30f, h * 0.10f), Color.White, InkAmber, fontScale = 0.82f)
    labelBox(tm, "3. Involution Mesoderm", Offset(w * 0.06f, h * 0.82f), Size(w * 0.42f, h * 0.10f), Color(0xFFE0F4F7), InkTeal, fontScale = 0.82f)
    labelBox(tm, "5. Yolk Plug", Offset(w * 0.58f, h * 0.82f), Size(w * 0.30f, h * 0.10f), InkAmberSoft, InkCoral, fontScale = 0.82f)
}

private fun DrawScope.drawHardyWeinberg(tm: TextMeasurer) {
    val w = size.width
    val h = size.height
    val x0 = w * 0.12f
    val x1 = w * 0.88f
    val y0 = h * 0.78f
    val y1 = h * 0.14f

    drawLine(InkSlate, Offset(x0, y0), Offset(x1, y0), strokeWidth = 3.5f)
    drawLine(InkSlate, Offset(x0, y0), Offset(x0, y1), strokeWidth = 3.5f)

    // Plot p^2, 2pq, q^2
    val steps = 30
    for (i in 0 until steps) {
        val pA = i / steps.toFloat()
        val pB = (i + 1) / steps.toFloat()
        val xA = x0 + (x1 - x0) * pA
        val xB = x0 + (x1 - x0) * pB

        fun mapY(v: Float) = y0 - (y0 - y1) * v

        drawLine(InkEmerald, Offset(xA, mapY(pA * pA)), Offset(xB, mapY(pB * pB)), strokeWidth = 5f)
        drawLine(InkAmber, Offset(xA, mapY(2f * pA * (1f - pA))), Offset(xB, mapY(2f * pB * (1f - pB))), strokeWidth = 5f)
        drawLine(InkTeal, Offset(xA, mapY((1f - pA) * (1f - pA))), Offset(xB, mapY((1f - pB) * (1f - pB))), strokeWidth = 5f)
    }

    labelBox(tm, "2. 2pq Max = 0.5", Offset(w * 0.34f, h * 0.25f), Size(w * 0.32f, h * 0.10f), InkAmberSoft, InkAmber, fontScale = 0.82f)
    labelBox(tm, "1. p²", Offset(w * 0.74f, h * 0.14f), Size(w * 0.16f, h * 0.09f), InkEmeraldSoft, InkEmerald, fontScale = 0.82f)
    labelBox(tm, "3. q²", Offset(w * 0.14f, h * 0.14f), Size(w * 0.16f, h * 0.09f), Color(0xFFE0F4F7), InkTeal, fontScale = 0.82f)
    labelBox(tm, "4. Allele Frequency p (0 -> 1)  |  p² + 2pq + q² = 1", Offset(w * 0.12f, h * 0.84f), Size(w * 0.76f, h * 0.10f), Color.White, InkSlate, fontScale = 0.80f)
}
