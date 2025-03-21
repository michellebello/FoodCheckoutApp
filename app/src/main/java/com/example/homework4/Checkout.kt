package com.example.homework4

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.util.Locale

@Composable
fun Checkout(navController: NavController, orderModel: OrderModel) {
    val locale = Locale.US // for string formatting
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top=100.dp)
    ) {
        Text(
            text = "Order Checkout",
            modifier = Modifier.padding(10.dp)
        )
        Column (
            horizontalAlignment = Alignment.Start
        ){
            Text ("Order Summary", modifier = Modifier.padding(10.dp))
            val listOfAllFoods = orderModel.getAllFoodItems()
            listOfAllFoods.forEach { food ->
                Row (
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = food.name,
                        fontSize = 12.sp
                    )
                    Text(
                        text = String.format(locale, "$%.2f", food.price),
                        fontSize = 12.sp
                    )
                }
            }
            Button(
                onClick = {navController.navigate(Screens.Main.name)}
            ) {
                Text("Go back to main page")
            }
        }
    }
}