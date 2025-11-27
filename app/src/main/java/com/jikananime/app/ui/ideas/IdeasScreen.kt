package com.jikananime.app.ui.ideas


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jikananime.app.data.room.Anime
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun IdeasScreen() {
    var ideaTitle by remember { mutableStateOf("") }
    var ideaSynopsis by remember { mutableStateOf("") }
    var ideaCreator by remember { mutableStateOf("") }
    var animeList by remember { mutableStateOf<List<Anime>>(emptyList())}
    var errorMessage by remember { mutableStateOf("") }

    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = Unit) {
        animeList = AnimeDbRepository.getMyAnimes()
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .padding(top = 30.dp, bottom = 30.dp),
        ) {
            Text(
                "Create your own anime!", fontSize = 30.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFFFFF)),
                textAlign = TextAlign.Center
            )

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                value = ideaTitle,
                onValueChange = { ideaTitle = it },
                label = {Text("Anime's title", fontStyle = FontStyle.Italic)},
                placeholder = {Text("Enter title")}
                )

            TextField(
                value = ideaSynopsis,
                onValueChange = { ideaSynopsis = it },
                label = {Text("Anime's synopsis")},
                placeholder = {Text("Enter synopsis", fontStyle = FontStyle.Italic)},
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 250.dp)
                    .padding(20.dp),
                maxLines = 5,
            )

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),

                value = ideaCreator,
                onValueChange = { ideaCreator = it },
                label = {Text("Anime's creator", fontStyle = FontStyle.Italic)},
                placeholder = {Text("Enter creator")},
            )

            Button(
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp),
                onClick = {
                    scope.launch {
                        if (ideaTitle.isNotBlank() && ideaSynopsis.isNotBlank() && ideaCreator.isNotBlank()) {
                            val newAnime = Anime(
                                title = ideaTitle,
                                synopsis = ideaSynopsis,
                                creator = ideaCreator
                            )
                            AnimeDbRepository.insertAnime(newAnime)
                            animeList = AnimeDbRepository.getMyAnimes()
                            ideaTitle = ""
                            ideaSynopsis = ""
                            ideaCreator = ""

                        } else{errorMessage = "Sorry you have to fill in all text fields"
                            scope.launch {
                                delay(5000)
                                errorMessage = ""
                            }
                        }

                    }
                }) {
                Text("Add anime")
            }
            if (errorMessage.isNotEmpty()) {
                Text(
                    text = errorMessage,
                    color = Color.Red,
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp)
                )
            }

            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 8.dp)
                    .shadow(
                        elevation = 8.dp,
                        shape = RoundedCornerShape(18.dp),
                        clip = false
                    )
            )
            {
                Text(text = "Anime ideas", fontSize = 18.sp)
            }

            animeList.forEach { anime ->
                Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp)) {
                    Text(text = "Title: ${anime.title}", fontSize = 18.sp)
                    Text(text = "Creator: ${anime.creator}", fontSize = 16.sp)
                    Text(text = "Synopsis: ${anime.synopsis}", fontSize = 12.sp)
                    Button(onClick = {
                        scope.launch {
                            AnimeDbRepository.deleteAnime(anime.id)
                            animeList = AnimeDbRepository.getMyAnimes()
                        }
                    }) {
                        Text("Delete anime")
                    }
                }
            }
        }
    }
}