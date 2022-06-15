package com.example.basicscodelab.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val bigButtonTextStyle = Typography.button.copy(
    fontWeight = FontWeight.Black,
    fontSize = 20.sp,
    color = Color.Red
)

val Typography.bigButtonText: TextStyle
    get() = bigButtonTextStyle