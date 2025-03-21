package com.example.homework4

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun Accompaniment (navController: NavController, orderModel: OrderModel) {
    val accompanimentFoods = listOf(
        FoodItem("Lunch Roll", "Fresh baked roll made in house",0.50),
        FoodItem("Mixed Berries", "Strawberries, blueberries, raspberries, and huckleberries", 1.00),
        FoodItem("Pickled Veggies", "Pickled cucumbers and carrots, made in house", 0.50)
    )
    ItemSelectorScreen(accompanimentFoods, Category.Accompaniment, Screens.Checkout.route, navController, orderModel)
}