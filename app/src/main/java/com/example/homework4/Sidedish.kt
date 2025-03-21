package com.example.homework4

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun Sidedish(navController: NavController, orderModel: OrderModel){
    val sidedishFoods = listOf(
        FoodItem("Summer Salad", "Heirloom tomatoes, butter lettuce, peaches, avocado, balsamic vinegar", 2.50),
        FoodItem("Butternut Squash Soup", "Roasted butternut squash, roasted peppers, chili oil", 3.00),
        FoodItem("Spicy Potatoes", "Marble potatoes, roasted, and fried in house spice blend", 2.00),
        FoodItem("Coconut Rice", "Rice, coconut, milk, lime, and sugar", 1.50)
    )
    ItemSelectorScreen(sidedishFoods, Category.SideDish, Screens.Accompaniment.route, navController, orderModel)
}