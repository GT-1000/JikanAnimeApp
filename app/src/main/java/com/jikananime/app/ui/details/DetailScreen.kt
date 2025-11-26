package com.jikananime.app.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun DetailScreen(
    animeId: Int,
    viewModel: DetailViewModel = viewModel()
) {
    val anime = viewModel.anime.value
    val loading = viewModel.loading.value
    val error = viewModel.error.value

    LaunchedEffect(animeId) {
        viewModel.loadAnime(animeId)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        when {
            loading -> CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )

            error != null -> Text(
                text = error,
                color = Color.Red,
                modifier = Modifier.align(Alignment.Center)
            )

            anime != null -> {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {

                    Text(
                        text = anime.title,
                        fontSize = 24.sp
                    )

                    Spacer(Modifier.height(16.dp))

                    Image(
                        painter = rememberAsyncImagePainter(anime.images.jpg.image_url),
                        contentDescription = anime.title,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                    )

                    Spacer(Modifier.height(16.dp))

                    Text(anime.synopsis)
                }
            }
        }
    }
}