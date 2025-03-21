package com.example.homework4

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class OrderModel : ViewModel() {
    private val _selectedFoodItems = mutableStateOf<Map<String, FoodItem?>>(emptyMap())
    val selectedFoodItems: State<Map<String, FoodItem?>> get() = _selectedFoodItems

    fun addFoodItem(foodType: String, foodItem: FoodItem?) {
        val newMap = _selectedFoodItems.value.toMutableMap()
        newMap[foodType] = foodItem
        _selectedFoodItems.value = newMap
    }

    fun getAllFoodItems(): List<FoodItem>{
        return _selectedFoodItems.value.values.filterNotNull()
    }

    fun getTotalPrice(): Double {
        var total = 0.0
        for (foodItem in _selectedFoodItems.value.values) {
            if (foodItem != null) {
                total += foodItem.price
            }
        }
        return total
    }
}