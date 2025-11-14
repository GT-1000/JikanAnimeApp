package com.jikananime.app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jikananime.app.ui.screen.animelist.AnimeListScreen
import com.jikananime.app.ui.screen.search.SearchScreen
import com.jikananime.app.ui.screen.ideas.IdeasScreen
import com.jikananime.app.ui.screen.custom.CustomScreen

sealed class Screen(val route: String) {
    object AnimeList : Screen("anime_list")
    object Search : Screen("search")
    object Ideas : Screen("ideas")
    object Custom : Screen("custom")
}

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.AnimeList.route
    ) {
        composable(Screen.AnimeList.route) { AnimeListScreen() }
        composable(Screen.Search.route) { SearchScreen() }
        composable(Screen.Ideas.route) { IdeasScreen() }
        composable(Screen.Custom.route) { CustomScreen() }
    }
}