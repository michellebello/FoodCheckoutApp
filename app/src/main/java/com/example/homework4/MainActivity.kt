package com.example.homework4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.homework4.ui.theme.Homework4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Homework4Theme {
                    val navController = rememberNavController()
                    val orderModel : OrderModel = viewModel()
                    NavHost(
                        navController = navController,
                        startDestination = Screens.Main.route
                    ) {
                        composable(route = Screens.Main.route) {
                            MainScreen(navController)
                        }
                        composable(route = Screens.Entree.route) {
                            Entree(navController, orderModel)
                        }
                        composable(route = Screens.SideDish.route){
                            Sidedish(navController, orderModel)
                        }
                        composable(route = Screens.Accompaniment.route){
                            Accompaniment(navController, orderModel)
                        }
                        composable(route = Screens.Checkout.route){
                            Checkout(navController, orderModel)
                        }
                }
            }
        }
    }
}

enum class Screens {
    Main,
    Entree,
    SideDish,
    Accompaniment,
    Checkout;
    val route: String
        get() = name
}

enum class Category {
    Entree,
    SideDish,
    Accompaniment,
    Checkout
}