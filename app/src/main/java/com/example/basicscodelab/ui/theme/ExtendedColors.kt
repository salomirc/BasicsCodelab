package com.example.basicscodelab.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class ExtendedColors(
    val tertiary: Color,
    val onTertiary: Color
)

val LocalExtendedColors = staticCompositionLocalOf {
    ExtendedColors(
        tertiary = Color.Unspecified,
        onTertiary = Color.Unspecified
    )
}

val DarkExtendedColorPalette = ExtendedColors(
    tertiary = CustomGray,
    onTertiary = CustomTeal
)

val LightExtendedColorPalette = ExtendedColors(
    tertiary = CustomTeal,
    onTertiary = CustomGray
)