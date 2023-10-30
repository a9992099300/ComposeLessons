package com.example.composelessons.ui.lessons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen21() {
    Column {
        MaterialTheme(
            colorScheme = lightColorScheme(primary = Color.Green)
        ) {
            Button(onClick = { }) {
                Text(text = "Some text")
            }
        }
        Button(onClick = { }) {
            Text(text = "Some text")
        }
    }
}
