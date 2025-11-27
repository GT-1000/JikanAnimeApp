package com.jikananime.app.ui.custom

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomScreen() {

    // Liste med anime facts
    val facts = listOf(
        "Cowboy Bebop was inspired by Lupin III and Bruce Lee.",
        "Attack on Titan was originally supposed to feature only Titans and no humans.",
        "Dragon Ball’s Super Saiyan transformation was created to save the animators time.",
        "Studio Ghibli’s Spirited Away is the highest grossing film in Japan’s history.",
        "Light Yagami’s lifespan is never shown, but it is implied he dies young.",
        "One Piece is the best selling manga of all time.",
        "Naruto was originally going to be about cooking!",
        "Saitama from One Punch Man was created as a joke character.",
        "My Hero Academia was inspired by American superheroes like Spider Man.",
        "Death Note was banned in several countries for being 'too realistic'."
    )

    // State for valgt fact
    var currentFact by remember { mutableStateOf(facts.random()) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Random Anime Fact",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = currentFact,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                    currentFact = facts.random()
                }
            ) {
                Text("Generate New Fact")
            }
        }
    }
}