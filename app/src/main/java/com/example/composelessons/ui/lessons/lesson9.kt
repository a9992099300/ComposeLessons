package com.example.composelessons.ui.lessons

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp


const val TAG ="testik"

@Composable
fun HomeScreen(
    counter: State<Int>,
    uppercase: State<Boolean>,
    onCounterClick: () -> Unit,
    onCheckedChange: (Boolean) -> Unit,
) {
    val counterValue = counter.value
    val uppercaseValue = uppercase.value
    Log.d(TAG, "HomeScreen")
    Column {
        ClickCounter(counterValue = counterValue, onCounterClick = onCounterClick, uppercase = uppercaseValue)
        InfoText(text = if (counterValue < 3) "More" else "Enough")
        Row(verticalAlignment = CenterVertically) {
            CheckBoxMy(uppercaseValue, onCheckedChange)
            Text("Upper",  fontSize = 18.sp)
        }
    }
}

@Composable
fun InfoText(text: String) {
    Log.d(TAG, "InfoText $text")
    Text(text = text, fontSize = 24.sp)
}

@Composable
fun CheckBoxMy(
    uppercase: Boolean,
    onCheckedChange: (Boolean) -> Unit,
) {
    Log.d(TAG, "CheckBoxMy")
    Checkbox(checked = uppercase, onCheckedChange = onCheckedChange)
}

@Composable
fun ClickCounter(
    uppercase: Boolean,
    counterValue: Int,
    onCounterClick: () -> Unit
) {
    val evenOdd = remember { EvenOdd(uppercase) } // сохраняет объект и не пересоздает его  при повотрном вызове функции
    Text(
        text = "Clicks: $counterValue ${evenOdd.check(counterValue)}",
        modifier = Modifier.clickable(onClick = onCounterClick)
    )
    Log.d(TAG, "ClickCounter $counterValue ${evenOdd.hashCode()}")
}

class EvenOdd(private val uppercase: Boolean) {
    fun check(value: Int): String {
        var result = if (value % 2 == 0) "even" else "odd"
        if (uppercase) result = result.uppercase()
        return result
    }

    override fun toString(): String {
        return "EvenOdd(uppercase = $uppercase, hashcode = ${hashCode()})"
    }
}