package com.jikananime.app.ui.screen.ideas

import android.provider.Settings
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun IdeasScreen() {
    var idea by remember {
        mutableStateOf("")
    }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .padding(top = 30.dp)
    ) {
        Text("Create your own anime!", fontSize = 40.sp,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0, 150, 100)),
            color = Color.White,
            textAlign = TextAlign.Center
        )

        Text("Here are all your ideas", fontSize = 30.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
            )

        Row(verticalAlignment = Alignment.CenterVertically) {

            TextField(
                value = idea,
                onValueChange = { idea = it },
                label = { Text("Anime's name") },
                placeholder = {}
            )

            Button(onClick = { print("test") }) {
                Text("Add anime")
            }
        }
    }

}