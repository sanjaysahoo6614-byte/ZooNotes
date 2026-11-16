package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

private val LightColorScheme = lightColorScheme(
    primary = EmeraldPrimary,
    onPrimary = EmeraldOnPrimary,
    primaryContainer = EmeraldPrimaryContainer,
    onPrimaryContainer = EmeraldOnPrimaryContainer,
    secondary = BotanicalSage,
    onSecondary = BotanicalOnSecondary,
    secondaryContainer = BotanicalSecondaryContainer,
    onSecondaryContainer = BotanicalOnSecondaryContainer,
    tertiary = AcademicAmber,
    onTertiary = AcademicOnTertiary,
    tertiaryContainer = AcademicAmberContainer,
    onTertiaryContainer = AcademicOnTertiaryContainer,
    background = AcademicBackground,
    onBackground = AcademicOnBackground,
    surface = AcademicSurface,
    onSurface = AcademicOnSurface,
    surfaceVariant = AcademicSurfaceVariant,
    onSurfaceVariant = AcademicOnSurfaceVariant,
    outline = AcademicOutline,
    outlineVariant = AcademicOutlineVariant,
    error = AcademicError,
    errorContainer = AcademicErrorContainer,
    onErrorContainer = AcademicOnErrorContainer
)

private val DarkColorScheme = darkColorScheme(
    primary = EmeraldDarkPrimary,
    onPrimary = EmeraldDarkOnPrimary,
    primaryContainer = EmeraldDarkPrimaryContainer,
    onPrimaryContainer = EmeraldDarkOnPrimaryContainer,
    secondary = BotanicalDarkSecondary,
    onSecondary = BotanicalDarkOnSecondary,
    secondaryContainer = BotanicalDarkSecondaryContainer,
    onSecondaryContainer = BotanicalDarkOnSecondaryContainer,
    tertiary = AcademicDarkTertiary,
    onTertiary = AcademicDarkOnTertiary,
    tertiaryContainer = AcademicDarkTertiaryContainer,
    onTertiaryContainer = AcademicDarkOnTertiaryContainer,
    background = AcademicDarkBackground,
    onBackground = AcademicDarkOnBackground,
    surface = AcademicDarkSurface,
    onSurface = AcademicDarkOnSurface,
    surfaceVariant = AcademicDarkSurfaceVariant,
    onSurfaceVariant = AcademicDarkOnSurfaceVariant,
    outlineVariant = AcademicDarkOutlineVariant
)

val AppShapes = Shapes(
    small = RoundedCornerShape(10.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(22.dp)
)

@Composable
fun ZooNotesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        shapes = AppShapes,
        content = content
    )
}
