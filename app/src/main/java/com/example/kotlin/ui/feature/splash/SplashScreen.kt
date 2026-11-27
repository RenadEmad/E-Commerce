package com.example.kotlin.ui.feature.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.kotlin.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(modifier: Modifier = Modifier,
                 onSplashClick:()->Unit
                 ) {
    LaunchedEffect(Unit) {
        delay(3000)
        onSplashClick()
    }
    
    Box(modifier = modifier.fillMaxSize())

    {
        Image(painter = painterResource(R.drawable.splash_ndpi),
            contentDescription = "splash",
            modifier = Modifier.fillMaxSize()
            )

    }
    
    
}