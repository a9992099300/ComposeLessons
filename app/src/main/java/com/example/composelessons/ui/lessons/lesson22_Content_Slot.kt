package com.example.composelessons.ui.lessons

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarResult
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen22() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Top bar")
                },
            )
        },
        bottomBar = {
            BottomNavigation {
                BottomNavigationItem(
                    icon = { Icon(Icons.Filled.Home, contentDescription = null) },
                    label = { Text("Home") },
                    selected = true,
                    onClick = { }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Filled.Call, contentDescription = null) },
                    label = { Text("Call") },
                    selected = false,
                    onClick = { }
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = null
                )
            }
        },
//        drawerContent = {
//            Text("Drawer item 1", modifier = Modifier.padding(8.dp))
//            Text("Drawer item 2", modifier = Modifier.padding(8.dp))
//            Text("Drawer item 3", modifier = Modifier.padding(8.dp))
//        },
        content = { paddingValues ->
            Box(
                modifier = Modifier.fillMaxSize().padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Text("Content")
            }
        }
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen221() {
    val scope = rememberCoroutineScope()

    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        content = {padding ->
            Text("Content", modifier = Modifier.padding(padding).clickable {
                scope.launch {
                    val result = scaffoldState.snackbarHostState
                        .showSnackbar(message = "Snackbar message", actionLabel = "Action")
                    when (result) {
                        SnackbarResult.Dismissed -> { }
                        SnackbarResult.ActionPerformed -> { }
                    }
                }
            })
        }
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen222() {
    val scope = rememberCoroutineScope()

    val scaffoldState = rememberBottomSheetScaffoldState()
    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = {
            repeat(5) {
                Text("Item $it", modifier = Modifier.padding(16.dp))
            }
        },
        content = {_ ->
            Text("Content", modifier = Modifier.clickable {
                scope.launch {
                    scaffoldState.bottomSheetState.run {
                        if (isCollapsed) expand() else collapse()
                    }
                }
            })
        }
    )
}

@Composable
fun Person(
    info: @Composable () -> Unit
) {
    Row {
//        Image(...)
//        Text(...)
        info()
    }
}