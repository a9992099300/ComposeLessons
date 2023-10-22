package com.example.composelessons.ui.lessons

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

@Composable
fun HomeScreen12(
    homeViewModel: HomeViewModel = viewModel()
) {
    val uiState by homeViewModel.uiState.collectAsState()
    HomeScreen12(
        uiState = uiState,
        onCounterClick = homeViewModel::onCounterClick,
        onEnabledChange = homeViewModel::setEnabled
    )
}

@Composable
fun HomeScreen12(
    uiState: HomeScreenUiState,
    onCounterClick: () -> Unit,
    onEnabledChange: (Boolean) -> Unit
) {
    Column {
        ClickCounter(
            count = uiState.count,
            onCounterClick = onCounterClick
        )
        EnableFeature(
            enabled = uiState.enabled,
            onEnabledChange = onEnabledChange
        )
    }
}

@Composable
fun ClickCounter(
    count: Int,
    onCounterClick: () -> Unit
) {
    Text(
        text = "Clicks: $count",
        modifier = Modifier.clickable(onClick = onCounterClick)
    )
}

@Composable
fun EnableFeature(
    enabled: Boolean,
    onEnabledChange: (Boolean) -> Unit
) {
    Row(verticalAlignment = CenterVertically) {
        Checkbox(checked = enabled, onCheckedChange = onEnabledChange)
        Text("enable feature")
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen12(
        uiState = HomeScreenUiState(count = 5, enabled = true),
        onCounterClick = {},
        onEnabledChange = {}
    )
}

class HomeViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(HomeScreenUiState())
    val uiState: StateFlow<HomeScreenUiState> = _uiState

    fun onCounterClick() {
        _uiState.update {
            it.copy(count = it.count + 1)
        }
    }

    fun setEnabled(enabled: Boolean) {
        _uiState.update {
            it.copy(enabled = enabled)
        }
    }

}

data class HomeScreenUiState(
    val count: Int = 0,
    val enabled: Boolean = false
)
