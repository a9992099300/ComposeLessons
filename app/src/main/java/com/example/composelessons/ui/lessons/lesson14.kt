package com.example.composelessons.ui.lessons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.fillMaxSize()) {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home", modifier = Modifier.weight(1f)) {
                    composable("home") { HomeScreen14(navController) }
                    composable("orders") { OrdersScreen() }
                    composable(
                        route = "user/{id}",
                        arguments = listOf(navArgument("id") { type = NavType.StringType })
                    ) {
                        val userId = it.arguments?.getString("id")
                        UsersScreen(userId)
                    }
//                    navigation(startDestination = "settings", route = "settings_graph") {
//                        composable("settings") { SettingsScreen() }
//                        composable("settings_private") { SettingsPrivateScreen() }
//                        composable("settings_data") { SettingsDataScreen() }
//                        composable("settings_about") { SettingsAboutScreen() }
//                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(text = "Home", modifier = Modifier.clickable { navController.navigate("home") })
                    Text(text = "Orders", modifier = Modifier.clickable {  navController.navigate("orders") })
                    Text(text = "Users", modifier = Modifier.clickable {  navController.navigate("users") })
                }
            }
        }
    }
}

@Composable
fun HomeScreen14(navController: NavHostController) {

    Column {
        Text(text = "Home screen")

        Text(
            text = "Orders",
            modifier = Modifier.clickable(onClick = { navController.navigate("orders") })
        )

        Text(
            text = "Users",
            modifier = Modifier.clickable(onClick = { navController.navigate("users") })
        )
    }
}

@Composable
fun OrdersScreen() {
    Text(text = "Orders screen")
}

@Composable
fun UsersScreen(id: String?) {
    Text(text = "Users screen")
}
