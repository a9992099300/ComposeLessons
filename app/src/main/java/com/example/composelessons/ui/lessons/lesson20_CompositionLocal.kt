package com.example.composelessons.ui.lessons


import android.os.Build
import android.text.Layout
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

data class MyTextStyle(
    val color: Color = Color.Unspecified,
    val fontSize: TextUnit = 12.sp,
    val align: TextAlign = TextAlign.Left
)

val LocalMyTextStyle = compositionLocalOf { MyTextStyle() }

 val LocalFontStyle = compositionLocalOf { FontStyle.Normal } //под копотом state то есть рекомпозиция только функций которые подписываются
//val LocalFontStyle = staticCompositionLocalOf { FontStyle.Normal } // тут перевызываются все функции

@Composable
fun HomeScreen20() {
    Column {
        val italicState = remember { mutableStateOf(false) }
        MyCheckbox("Italic", italicState)

        val fontStyle = if (italicState.value) FontStyle.Italic else FontStyle.Normal
       // val localFontStyle = LocalFontStyle.provides(fontStyle)
        val myTextStyle = MyTextStyle(
                color = Color.Green,
                fontSize = 16.sp
        )
        CompositionLocalProvider(LocalMyTextStyle provides myTextStyle) {
            MyText(text = "Text 1")
            MyText(text = "Text 2")
            MyText(text = "Text 3")
            MyText(text = "Text 4")
        }
//        CompositionLocalProvider(LocalFontStyle provides fontStyle) {
//
//        }
        MyText(text = "Text 5")
    }
}

@Composable
fun HomeScreen201() {
    Column {
        val italicState = remember { mutableStateOf(false) }
        MyCheckbox("Italic", italicState)

        Log.d(TAG, "HomeScreen ${italicState.value}")

        val fontStyle = if (italicState.value) FontStyle.Italic else FontStyle.Normal
        CompositionLocalProvider(LocalFontStyle provides fontStyle) {
            MyText(text = "Text")
            Test()
        }
    }
}

@Composable
fun MyCheckbox(
    text: String,
    checked: MutableState<Boolean>,
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = checked.value, onCheckedChange = { checked.value = it })
        Text(text = text)
    }
}

@Composable
fun MyText(
    text: String,
) {
    Log.d(TAG, "MyText")
  //  Text(text = text, fontStyle = LocalFontStyle.current)
    val myTextStyle = LocalMyTextStyle.current
    Text(
        text = text,
        color = myTextStyle.color,
        textAlign = myTextStyle.align,
        fontSize = myTextStyle.fontSize
    )
}

@Composable
fun Test() {
    Log.d(TAG, "Test")
    Text(text = "Test")
}

