package com.jikananime.app.ui.screen.ideas

import android.provider.Settings
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun IdeasScreen() {

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
    }

}