package com.jikananime.app.ui.animelist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun AnimeListScreen(
    viewModel: AnimeListViewModel = viewModel()
) {
    val animeList by viewModel.animeList

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(animeList) { anime ->
            Row(modifier = Modifier.padding(8.dp)) {
                Image(
                    painter = rememberAsyncImagePainter(anime.images.jpg.image_url),
                    contentDescription = anime.url,
                    modifier = Modifier.size(80.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(anime.url)
            }
        }
    }
}