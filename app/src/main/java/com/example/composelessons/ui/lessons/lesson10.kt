package com.example.composelessons.ui.lessons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.example.composelessons.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun HomeScreenL10(
) {
    var checked by remember  { mutableStateOf(false) } // rememberSaveable переживает смерть активити
    Column {
        Row(verticalAlignment = CenterVertically) {
            Checkbox(checked = checked, onCheckedChange = { value -> checked = value })
            Text("More details", fontSize = 18.sp)
        }
        if (checked) {
            Text(text = stringResource(id = R.string.app_name))
        }
    }
}