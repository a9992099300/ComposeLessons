package com.example.composelessons

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.composelessons.ui.lessons.HomeScreen
import com.example.composelessons.ui.lessons.HomeScreen112
import com.example.composelessons.ui.lessons.HomeScreen16
import com.example.composelessons.ui.lessons.HomeScreen17
import com.example.composelessons.ui.lessons.HomeScreen20
import com.example.composelessons.ui.lessons.HomeScreen21
import com.example.composelessons.ui.lessons.HomeScreen22
import com.example.composelessons.ui.lessons.HomeScreen221
import com.example.composelessons.ui.theme.ComposeLessonsTheme
import com.example.composelessons.ui.theme.MyComposeApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val upper = mutableStateOf(false)
        val count = mutableStateOf(0)
        setContent {
            setContent {
                MyComposeApplicationTheme {
                    HomeScreen221()
                }
            }


//            ComposeLessonsTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    setContent {
//                        MaterialTheme(
//                            colors = lightColors(primary = Color.Green)
//                        ) {
//                            HomeScreen21()
//                        }
//                    }
//                }
//            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeLessonsTheme {
        Greeting("Android")
    }
}

