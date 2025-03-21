package com.example.homework4

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun Entree(navController: NavController, orderModel: OrderModel){
    val entreeFoods = listOf(
        FoodItem("Cauliflower", "Whole cauliflower, brined, roasted, and deep fried", 7.00),
        FoodItem("Three Bean Chili", "Black beans., red beans, kidney beans, slow cooked, topped with onion", 4.00),
        FoodItem("Mushroom Pasta", "Penne pasta, mushrooms, basil, with plum tomatoes cooked in garlic and olive oil", 5.50),
        FoodItem("Spicy Black Bean Skillet", "Seasonal vegetables, black beans, house spice blend, served with avocado and quick pickled onions", 5.50)
    )
    ItemSelectorScreen(entreeFoods, Category.Entree, Screens.SideDish.route, navController, orderModel)
}