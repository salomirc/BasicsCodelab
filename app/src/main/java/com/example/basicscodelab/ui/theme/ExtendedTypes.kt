package com.example.basicscodelab.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Immutable
data class ExtendedTypes(
    val bigButtonText: TextStyle
)

val LocalExtendedTypes = staticCompositionLocalOf {
    ExtendedTypes(
        bigButtonText = TextStyle.Default
    )
}

val ExtendedTypography = ExtendedTypes(
    bigButtonText = Typography.button.copy(
        fontWeight = FontWeight.Black,
        fontSize = 20.sp,
        color = Color.Red
    )
)