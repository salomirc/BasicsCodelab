package com.example.basicscodelab.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

val cellHeaderTextStyle = Typography.h5.copy(
    fontWeight = FontWeight.Black
)
val cellTitleTextStyle = Typography.h5.copy(
    fontWeight = FontWeight.Bold
)


val Typography.cellHeader: TextStyle
    get() = cellHeaderTextStyle

val Typography.cellTitle: TextStyle
    get() = cellTitleTextStyle