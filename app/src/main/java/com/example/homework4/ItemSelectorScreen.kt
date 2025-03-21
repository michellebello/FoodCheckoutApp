package com.example.homework4

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.util.Locale


data class FoodItem (val name: String, val description: String, val price: Double)

@Composable
fun ItemSelectorScreen(foods: List<FoodItem>, screenCategory: Category, nextRoute: String, navController: NavController, orderModel: OrderModel) {
    var (selectedFood, onSelectedFood) = remember { mutableStateOf<FoodItem?>(null) }
    val locale = Locale.US // for string formatting
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
    ) {
        foods.forEach { food ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(145.dp)
                        .selectable(
                            selected = (food == selectedFood),
                            onClick = { onSelectedFood(food) },
                            role = Role.RadioButton
                        )
                ) {
                    RadioButton(
                        selected = (food == selectedFood),
                        onClick = null,
                        modifier = Modifier.padding(start = 20.dp, end = 10.dp)
                    )

                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(end=20.dp)
                    ) {
                        Text(
                            text = food.name,
                            fontSize = 18.sp,
                            modifier = Modifier.padding(5.dp)
                        )
                        Text(text = food.description, modifier = Modifier.padding(5.dp))
                        Text(text = String.format(locale, "$%.2f", food.price),  modifier = Modifier.padding(5.dp))
                        HorizontalDivider(
                            color = Color.Gray,
                            thickness = 1.5.dp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp)
                        )
                    }
                }
        }
        Spacer(modifier = Modifier.weight(1f))
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button (
                onClick = { selectedFood = null }
            ) {
                Text(text = "Cancel")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button (
                onClick = { selectedFood?.let {
                    orderModel.addFoodItem(screenCategory.toString(), it) }
                    navController.navigate(nextRoute)
                }
            ) {
                Text(text = "Next")
            }
        }
    }
}