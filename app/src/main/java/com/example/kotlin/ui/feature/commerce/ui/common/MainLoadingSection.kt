package com.example.kotlin.ui.feature.commerce.ui.common

import android.graphics.Color
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MainLoadingSection(modifier: Modifier = Modifier,

                       ) {
    Box(modifier = Modifier.fillMaxSize(),

        contentAlignment = Alignment.Center)
    {
        CircularProgressIndicator(

        )
    }
}