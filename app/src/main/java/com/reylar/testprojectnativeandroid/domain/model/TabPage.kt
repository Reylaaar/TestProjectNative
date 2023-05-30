package com.reylar.testprojectnativeandroid.domain.model

import androidx.compose.runtime.Composable

data class TabPage(
    val content: @Composable () -> Unit,
    val type: String
)