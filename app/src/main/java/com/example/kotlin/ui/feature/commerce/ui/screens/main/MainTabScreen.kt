package com.example.kotlin.ui.feature.commerce.ui.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.kotlin.ui.feature.commerce.ui.components.CustomButtomBar
import com.example.kotlin.ui.feature.commerce.ui.tabs.favourite.FavouriteTab
import com.example.kotlin.ui.feature.commerce.ui.tabs.home.HomeTab
import com.example.kotlin.ui.feature.commerce.ui.tabs.product.ProductTab
import com.example.kotlin.ui.feature.commerce.ui.tabs.profile.ProfileTab

@Composable
fun MainTabScreen(modifier: Modifier = Modifier) {
    val colorScheme = MaterialTheme.colorScheme
    var selectedIndex by remember { mutableIntStateOf(0) }

    Scaffold(
        modifier = modifier,
        bottomBar = {
            CustomButtomBar(
                colorScheme = colorScheme,
                selectedIndex = selectedIndex,
                onTabClick = { selectedIndex = it }
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (selectedIndex) {
                0 -> HomeTab()
                1 -> ProductTab()
                2 -> FavouriteTab()
                3 -> ProfileTab()
            }
        }
    }
}