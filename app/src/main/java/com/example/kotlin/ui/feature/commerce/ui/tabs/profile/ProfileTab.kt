package com.example.kotlin.ui.feature.commerce.ui.tabs.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun ProfileTab(modifier: Modifier = Modifier,

                 ) {
    val colorScheme= MaterialTheme.colorScheme

    Box(

        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.LightGray
            )
    ) {
        Text(text = "Prooofile",
            style = TextStyle(
                color = Color.Black, fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
        )

    }
}