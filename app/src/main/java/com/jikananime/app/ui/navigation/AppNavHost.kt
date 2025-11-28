@file:OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)

package com.jikananime.app.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.jikananime.app.ui.animelist.AnimeListScreen
import com.jikananime.app.ui.custom.CustomScreen
import com.jikananime.app.ui.details.DetailScreen
import com.jikananime.app.ui.ideas.IdeasScreen
import com.jikananime.app.ui.search.SearchScreen

@Composable
fun AppNavHost(navController: NavHostController) {

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route ?: Screen.AnimeList.route

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        when {
                            currentRoute.startsWith("details") -> "Back"
                            currentRoute == Screen.Search.route -> "Search"
                            currentRoute == Screen.Ideas.route -> "Ideas"
                            currentRoute == Screen.Custom.route -> "Anime Facts"
                            else -> "Top Anime"
                        }
                    )
                },
                navigationIcon = {
                    if (currentRoute.startsWith("details")) {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    }
                }
            )
        },
        bottomBar = {
            if (!currentRoute.startsWith("details")) {
                BottomNavBar(navController, currentRoute)
            }
        }
    ) { padding ->

        NavHost(
            navController = navController,
            startDestination = Screen.AnimeList.route,
            modifier = Modifier.padding(padding)
        ) {

            // SCREEN 1
            composable(Screen.AnimeList.route) {
                AnimeListScreen(
                    onAnimeClick = { id ->
                        navController.navigate(Screen.Details.create(id))
                    }
                )
            }

            // DETAILS
            composable(
                Screen.Details.route,
                arguments = listOf(
                    navArgument("id") { type = NavType.IntType }
                )
            ) { backStack ->
                val id = backStack.arguments?.getInt("id") ?: 0
                DetailScreen(animeId = id)
            }

            // SCREEN 2
            composable(Screen.Search.route) {
                SearchScreen()
            }

            // SCREEN 3
            composable(Screen.Ideas.route) {
                IdeasScreen()
            }

            // SCREEN 4
            composable(Screen.Custom.route) {
                CustomScreen()
            }
        }
    }
}