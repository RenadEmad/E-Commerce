package com.example.kotlin.ui.feature.commerce.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

data class Tabs(
    val icon: ImageVector,
    val contentDescription: String,
    val index: Int
)

val tabsList = listOf(
    Tabs(Icons.Default.Home, "Home", 0),
    Tabs(Icons.Default.Category, "Categories", 1),
    Tabs(Icons.Default.Favorite, "Favorites", 2),
    Tabs(Icons.Default.Person, "Profile", 3)
)

@Composable
fun CustomButtomBar(
    modifier: Modifier = Modifier,
    colorScheme: ColorScheme,
    selectedIndex: Int,
    onTabClick: (Int) -> Unit
) {
    NavigationBar(
        modifier = modifier,
        containerColor = colorScheme.primary
    ) {
        tabsList.forEach { tab ->
            NavigationBarItem(
                selected = selectedIndex == tab.index,
                onClick = { onTabClick(tab.index) },
                icon = {
                    Icon(
                        imageVector = tab.icon,
                        contentDescription = tab.contentDescription
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = colorScheme.primary,
                    unselectedIconColor = colorScheme.secondary,
                    indicatorColor = colorScheme.secondary
                )
            )
        }
    }
}