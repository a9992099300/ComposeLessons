package com.example.composelessons.ui.lessons

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay

//В этом уроке рассматриваем SideEffects функции:
// produceState, rememberUpdatedState, SideEffect

@Composable
fun HomeScreen18(
) {
    val count by produceState(initialValue = 0) {
        while (true) {
            delay(1000)
            value++
        }
       awaitDispose {

        }
    }
    //produceState создает и возвращает нам State, а в его блоке кода (корутине)
    // мы используем поле value, чтобы менять значение этого State.
    // Раз в секунду мы увеличиваем это значение на 1.

    Text(text = "count = $count")
}

@Composable
fun HomeScreen181(
) {
    Column {
        var sliderPosition by remember { mutableStateOf(1f) }
        Slider(
            value = sliderPosition,
            valueRange = 1f..10f,
            onValueChange = { sliderPosition = it })

        TrackPosition(position = sliderPosition)
    }
}

@Composable
fun TrackPosition(position: Float) {

    val positionState = rememberUpdatedState(newValue = position)

    LaunchedEffect(key1 = Unit) {
        while(true) {
            delay(1000)
            Log.d(TAG, "track position ${positionState.value}")
        }
    }
}

//@Composable
//fun TrackPosition(position: Float) {
//    val positionState = remember {
//        mutableStateOf(position)
//    }
//
//    positionState.value = position
//    LaunchedEffect(key1 = Unit) {
//        while(true) {
//            delay(1000)
//            Log.d(TAG, "track position ${positionState.value}")
//        }
//    }
//}