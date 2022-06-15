package com.example.basicscodelab.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val Colors.tertiary: Color
    get() = if (isLight) CustomTeal else CustomGray

val Colors.onTertiary: Color
    get() = if (isLight) CustomGray else CustomTeal