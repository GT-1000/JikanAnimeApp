package com.jikananime.app.ui.search

import android.R.attr.contentDescription
import android.R.attr.label
import android.R.attr.text
import android.R.id.bold
import androidx.compose.foundation.Image
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImagePainter.State.Empty.painter
import coil.compose.rememberAsyncImagePainter
import com.jikananime.app.ui.screen.search.SearchViewModel

@Composable
fun SearchScreen(searchViewModel: SearchViewModel = viewModel()) {

    val anime = searchViewModel.anime.collectAsState()
    val error = searchViewModel.error.collectAsState()
    val loading = searchViewModel.loading.collectAsState()
    var id by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Text("Søk etter anime (ID)")
        TextField(
            value = id,
            onValueChange = {id = it},
            label = {Text("Anime ID")}
        )
        OutlinedButton(
            onClick = {
                val parsed = id.toIntOrNull()
                if (parsed != null){
                    searchViewModel.searchById(parsed)
                }
            }
        ) {
            Text("Søk")
        }

        Spacer(modifier = Modifier.height(12.dp))

        if (loading.value) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Laster...")
            }
            return@Column
        }

        error.value?.let { err->
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = err,
                    color = Red

                )
            }
            return@Column
        }

        anime.value?.let { animeData ->
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = animeData.title,
                    fontSize = 22.sp,
                    fontWeight = Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                val imageUrl = animeData.images.jpg.image_url

                Image(
                    painter = rememberAsyncImagePainter(model = imageUrl),
                    contentDescription = animeData.title,
                    modifier = Modifier
                        .size(250.dp)
                        .padding(top = 16.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(text = animeData.synopsis)
            }

        } ?: Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Ingen anime – skriv ID og søk")
        }
    }
}