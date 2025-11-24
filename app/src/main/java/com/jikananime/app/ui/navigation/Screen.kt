package com.jikananime.app.ui.navigation

sealed class Screen(val route: String) {

    // Screen 1 Anime list
    object AnimeList : Screen("anime_list")

    // Screen 2 Search
    object Search : Screen("search")

    // Screen 3 Ideas
    object Ideas : Screen("ideas")

    // Screen 4 Custom
    object Custom : Screen("custom")

    // Details (for 1 og 2)
    object Details : Screen("details/{id}") {
        fun create(id: Int) = "details/$id"
    }
}