package com.example.composelessons.ui.lessons

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.sample
import kotlin.math.roundToInt

@Composable
fun HomeScreen19() {
    Column {
        var count by remember { mutableStateOf(0) }
        Text(text = "count = $count", modifier = Modifier.clickable { count++ })

        val countBinary by remember { derivedStateOf { count.toString(2) } }
        Text(text = "countBinary = $countBinary")
        //Функция derivedStateOf умеет создавать State,
        // который читает значения из других State и подписывается на них.
    }
}

@Composable
fun HomeScreen191(
) {
    Column {
        val sliderPosition = remember { mutableStateOf(1f) }
        MySlider(sliderPosition)
        val roundedPosition by remember {
            derivedStateOf {
                sliderPosition.value.roundToInt()
            }
        }
        Text(text = "$roundedPosition")
        Log.d(TAG, "HomeScreen $roundedPosition")
    }
}

@Composable
fun MySlider(sliderPosition: MutableState<Float>) {
    Slider(
        value = sliderPosition.value,
        valueRange = 1f..10f,
        onValueChange = { sliderPosition.value = it }
    )
}

@Composable
fun HomeScreen192(
) {
    Column {
        val sliderPosition = remember { mutableStateOf(1f) }
        Slider(
            value = sliderPosition.value,
            valueRange = 1f..10f,
            onValueChange = { sliderPosition.value = it })

        TrackPosition192(position = sliderPosition)
    }
}

@Composable
fun TrackPosition192(position: State<Float>) {
    LaunchedEffect(key1 = Unit) {
        val flow = snapshotFlow { position.value }
            .filter { it > 3 }
            .sample(1000)

        flow.collect {
            Log.d(TAG, "track position $it")
        }
    }
}

//@HiltViewModel
//class HomeViewModel @Inject constructor() : ViewModel() {
//
//    val sliderPosition = mutableStateOf(1f)
//
//    init {
//        viewModelScope.launch {
//            val flow = snapshotFlow { sliderPosition.value }
//                .filter { it > 3 }
//                .sample(1000)
//
//            flow.collect {
//                Log.d(TAG, "track position $it")
//            }
//        }
//    }
//
//}

//@Composable
//fun HomeScreen(
//    homeViewModel: HomeViewModel = hiltViewModel()
//) {
//    Column {
//        Slider(
//            value = homeViewModel.sliderPosition.value,
//            valueRange = 1f..10f,
//            onValueChange = { homeViewModel.sliderPosition.value = it })
//    }
//}