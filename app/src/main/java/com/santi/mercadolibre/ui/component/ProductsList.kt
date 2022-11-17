package com.santi.mercadolibre.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.santi.mercadolibre.models.ResponseResult

@Composable
fun ProductsList(products: List<ResponseResult>, navController: NavController) {
    LazyColumn(modifier = Modifier.background(MaterialTheme.colors.background)) {
        items(products) { product ->
            ProductItemView(product, navController)
        }
    }
}