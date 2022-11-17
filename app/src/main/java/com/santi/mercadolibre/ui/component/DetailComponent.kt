package com.santi.mercadolibre.ui.component

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun DetailComponent(navController: NavController, id: String?) {
    Log.d("prueba", "Vamos: $id")
}