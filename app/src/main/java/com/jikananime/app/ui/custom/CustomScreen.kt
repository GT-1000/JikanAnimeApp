package com.jikananime.app.ui.custom

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun CustomScreen() {

    val facts = listOf(
        "Cowboy Bebop was inspired by Lupin III and Bruce Lee.",
        "Attack on Titan was originally supposed to have ONLY Titans and no humans.",
        "Super Saiyan was invented to save time coloring Goku’s hair.",
        "Spirited Away is one of Japan’s most awarded animated films ever.",
        "One Piece is the best selling manga in history.",
        "Naruto was originally based on a one shot about a fox character.",
        "Saitama was created as a joke/parody hero.",
        "My Hero Academia was inspired by American superhero comics.",
        "Death Note was banned in several countries for being too realistic.",
        "Demon Slayer became Japan’s #1 highest grossing film."
    )

    val imageUrls = listOf(
        "https://cdn.myanimelist.net/images/anime/4/19644.jpg",   // Bebop
        "https://cdn.myanimelist.net/images/anime/10/47347.jpg", // AoT
        "https://cdn.myanimelist.net/images/anime/6/20618.jpg",  // DBZ
        "https://cdn.myanimelist.net/images/anime/6/79597.jpg",  // Spirited Away
        "https://cdn.myanimelist.net/images/anime/6/73245.jpg",  // One Piece
        "https://cdn.myanimelist.net/images/anime/13/17405.jpg", // Naruto
        "https://cdn.myanimelist.net/images/anime/12/76049.jpg", // OPM
        "https://cdn.myanimelist.net/images/anime/10/78745.jpg", // BNHA
        "https://cdn.myanimelist.net/images/anime/9/9453.jpg",   // Death Note
        "https://cdn.myanimelist.net/images/anime/1286/99889.jpg" // Demon Slayer
    )

    var currentIndex by remember { mutableStateOf((facts.indices).random()) }

    val currentFact = facts[currentIndex]
    val currentImage = imageUrls[currentIndex]

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Random Anime Fact",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            Image(
                painter = rememberAsyncImagePainter(model = currentImage),
                contentDescription = "Anime image",
                modifier = Modifier
                    .size(250.dp)
                    .padding(10.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = currentFact,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = {
                    currentIndex = (facts.indices).random()
                }
            ) {
                Text("Generate New Fact")
            }
        }
    }
}