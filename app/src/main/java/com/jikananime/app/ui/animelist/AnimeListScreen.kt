package com.jikananime.app.ui.animelist

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter

@Composable
fun AnimeListScreen(
    onAnimeClick: (Int) -> Unit,
    viewModel: AnimeListViewModel = viewModel()
) {
    val animeList by viewModel.animeList
    val isLoading by viewModel.isLoading
    val errorMessage by viewModel.errorMessage

    Box(modifier = Modifier.fillMaxSize()) {

        when {
            isLoading -> CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )

            errorMessage != null -> Text(
                text = "Feil: $errorMessage",
                color = Color.Red,
                modifier = Modifier.align(Alignment.Center)
            )

            else -> LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
            ) {
                itemsIndexed(animeList) { index, anime ->
                    AnimeListItem(
                        number = index + 1,
                        title = anime.title,
                        imageUrl = anime.images.jpg.image_url,
                        onClick = { onAnimeClick(anime.mal_id) }
                    )
                }
            }
        }
    }
}

@Composable
fun AnimeListItem(
    number: Int,
    title: String,
    imageUrl: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
            .clickable { onClick() }
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(18.dp),
                clip = false
            ),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {

        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Number box
            Text(
                text = "$number.",
                style = MaterialTheme.typography.titleMedium,
                color = Color(0xFF7A7A7A),
                modifier = Modifier.padding(end = 16.dp)
            )

            // Image
            val painter = rememberAsyncImagePainter(model = imageUrl)

            Image(
                painter = painter,
                contentDescription = title,
                modifier = Modifier
                    .size(85.dp)
                    .clip(RoundedCornerShape(14.dp))
            )

            Spacer(modifier = Modifier.width(18.dp))

            Column(modifier = Modifier.fillMaxWidth()) {

                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Trykk for detaljer",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF6F6F6F)
                )
            }
        }
    }
}