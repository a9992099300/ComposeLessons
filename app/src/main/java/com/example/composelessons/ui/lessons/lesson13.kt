package com.example.composelessons.ui.lessons

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen13() {
    Box(
        modifier = Modifier.size(200.dp)
            .border(2.dp, Color.Black)
            .background(Color.Green)
            .padding(32.dp)
    ) {
        Text(text = "Some text", fontSize = 30.sp)
    }
}