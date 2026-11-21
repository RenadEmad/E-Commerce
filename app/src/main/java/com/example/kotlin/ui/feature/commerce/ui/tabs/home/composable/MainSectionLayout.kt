package com.example.kotlin.ui.feature.commerce.ui.tabs.home.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Composable
fun MainSectionLayout(modifier: Modifier = Modifier, text: String, viewAll: String) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontWeight = FontWeight.Medium,
                color = colorScheme.onPrimary,
                fontSize = 18.sp
            )
        )
        Text(
            text = viewAll,
            style = TextStyle(
                fontWeight = FontWeight.Medium,
                color = colorScheme.onPrimary,
                fontSize = 18.sp
            )
        )
    }
}