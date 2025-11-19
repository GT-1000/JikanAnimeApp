package com.jikananime.app.ui.screen.ideas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun IdeasScreen() {
    var ideaTitle by remember {
        mutableStateOf("")
    }
    var ideaSynopsis by remember {
        mutableStateOf("")
    }
    var ideaCreator by remember {
        mutableStateOf("")
    }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .padding(top = 30.dp)
            .background(Color(122, 158, 159))
    ) {
        Text("Create your own anime!", fontSize = 40.sp,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(247, 151, 126)),
            color = Color(30,30,30),
            textAlign = TextAlign.Center
        )

        Text("Here are all your ideas", fontSize = 30.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
            )


            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                value = ideaTitle,
                onValueChange = { ideaTitle = it },
                label = { Text("Anime's title") },
                placeholder = {},
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(253, 181, 200),
                    unfocusedContainerColor = Color(253, 181, 200)
                )
            )

            TextField(
                value = ideaSynopsis,
                onValueChange = { ideaSynopsis = it },
                label = { Text("Anime's synopsis") },
                placeholder = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 500.dp)
                    .padding(20.dp)
                ,
                maxLines = 5,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(169, 200, 245),
                    unfocusedContainerColor = Color(169, 200, 245)
                )
                )


            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                ,
                value = ideaCreator,
                onValueChange = { ideaCreator = it },
                label = { Text("Anime's creator") },
                placeholder = {},
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(167, 217, 168),
                    unfocusedContainerColor = Color(167, 217, 168)
                )
            )


        Button(onClick = { print("test") }) {
            Text("Add anime")
        }
    }

}