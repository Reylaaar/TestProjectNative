package com.reylar.testprojectnativeandroid.presentation.common

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun CustomTab(
    modifier: Modifier = Modifier,
    tab: String,
    isSelected: Boolean,
    onSelectTab: () -> Unit,
    selectedColor: Color = Color(0xFF0A3FFF),
    unselectedContentColor: Color = Color(0xFF72777A),
) {

    Tab(
        modifier = modifier,
        unselectedContentColor = unselectedContentColor,
        selectedContentColor = selectedColor,
        text = {
            Text(
                text = tab,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.W400,
                    lineHeight = 16.sp,
                ),
            )
        },
        selected = isSelected,
        onClick = onSelectTab,
    )
}