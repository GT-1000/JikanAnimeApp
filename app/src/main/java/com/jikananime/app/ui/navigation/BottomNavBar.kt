package com.jikananime.app.ui.navigation

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.TipsAndUpdates

@Composable
fun BottomNavBar(navController: NavHostController, currentRoute: String?) {
    NavigationBar {

        // 1. Anime screen
        NavigationBarItem(
            selected = currentRoute == Screen.AnimeList.route,
            onClick = { navController.navigate(Screen.AnimeList.route) },
            icon = { Icon(Icons.Filled.List, contentDescription = "Anime List") },
            label = { Text("Anime") }
        )

        // 2. Search screen
        NavigationBarItem(
            selected = currentRoute == Screen.Search.route,
            onClick = { navController.navigate(Screen.Search.route) },
            icon = { Icon(Icons.Filled.Search, contentDescription = "Search") },
            label = { Text("Search") }
        )

        // 3. Ideas screen
        NavigationBarItem(
            selected = currentRoute == Screen.Ideas.route,
            onClick = { navController.navigate(Screen.Ideas.route) },
            icon = { Icon(Icons.Filled.TipsAndUpdates, contentDescription = "Ideas") },
            label = { Text("Ideas") }
        )


        // 4. Custom screen
        NavigationBarItem(
            selected = currentRoute == Screen.Custom.route,
            onClick = { navController.navigate(Screen.Custom.route) },
            icon = { Icon(Icons.Filled.Star, contentDescription = "Custom") },
            label = { Text("Anime Facts") }
        )
    }
}