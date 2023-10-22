package com.example.composelessons.ui.lessons

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MainActivity15 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.fillMaxSize()) {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "userList",
                    modifier = Modifier.weight(1f)
                ) {
                    composable("userList") { UserListScreen(
                        onUser1Click = { navController.navigate("user/1") },
                        onUser2Click = { navController.navigate("user/2") }
                    ) }
                    composable(
                        route = "user/{id}",
                        arguments = listOf(navArgument("id") { type = NavType.StringType })
                    ) {
                        val userId = it.arguments?.getString("id")
                        UserScreen2(userId)
                    }
                }

                Text(
                    text = "Users",
                    modifier = Modifier.clickable { navController.navigate("userList") }
                )
            }

//            Column(modifier = Modifier.fillMaxSize()) {
//                var route by remember { mutableStateOf("userList") }
//
//                Box(modifier = Modifier.weight(1f)) {
//                    when (route) {
//                        "userList" -> UserListScreen(
//                            onUser1Click = { route = "user/1" },
//                            onUser2Click = { route = "user/2" }
//                        )
//                        "user/1" -> UserScreen2("1")
//                        "user/2" -> UserScreen2("2")
//                    }
//                }
//
//                Text(
//                    text = "Users",
//                    modifier = Modifier.clickable { route = "userList" }
//                )
//            }
        }
    }
}

@Composable
fun UserScreen2(
    id: String?,
    userViewModel: UserViewModel = viewModel() // у всех экранов будут разные вью модели
//если надо шарить вьюмодел надо передать вью модел оунер при сохдание вьею модели
) {
    Text(text = "User $id")
    Log.d(TAG,"user $id")
    Log.d(TAG,"viewModel ${userViewModel.hashCode()}")
}

class UserViewModel: ViewModel() {

//    private val _uiState = MutableStateFlow(HomeScreenUiState())
//    val uiState: StateFlow<HomeScreenUiState> = _uiState
//
//    fun onCounterClick() {
//        _uiState.update {
//            it.copy(count = it.count + 1)
//        }
//    }
//
//    fun setEnabled(enabled: Boolean) {
//        _uiState.update {
//            it.copy(enabled = enabled)
//        }
//    }

}

@Composable
fun UserListScreen(
    onUser1Click: () -> Unit,
    onUser2Click: () -> Unit,
) {
    Column {
        Text(text = "Users screen")
        Text(
            text = "User 1",
            modifier = Modifier.clickable(onClick = onUser1Click)
        )
        Text(
            text = "User 2",
            modifier = Modifier.clickable(onClick = onUser2Click)
        )
    }
}