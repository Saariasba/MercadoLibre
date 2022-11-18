package com.santi.mercadolibre

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.santi.mercadolibre.navigation.AppNavigation
import com.santi.mercadolibre.ui.component.*
import com.santi.mercadolibre.ui.theme.MercadoLibreTheme
import com.santi.mercadolibre.utils.DEBUG
import com.santi.mercadolibre.utils.ERROR
import com.santi.mercadolibre.utils.Status
import com.santi.mercadolibre.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

//Activity principal y punto de inicio de la App
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MercadoLibreTheme {
                AppNavigation(mainViewModel = mainViewModel)
            }
        }
    }
}

//Componente Principal Del Home
@Composable
fun PrincipalComponent(navController: NavController, mainViewModel: MainViewModel) {
    val products = mainViewModel.products.collectAsState().value
    val categories = mainViewModel.categories.collectAsState().value
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SearchBar(mainViewModel)
        when (products.status) {
            Status.LOADING -> repeat(8) { ListSearchShimmer() }
            Status.SUCCESS -> {
                Log.d(DEBUG, products.data.toString())
                products.data?.results?.let { ProductsList(it, navController) }
            }
            Status.ERROR -> {
                Log.e(ERROR, products.data.toString())
                NoResults(navController = navController)
            }
        }
        when (categories.status) {
            Status.LOADING -> repeat(8) { ListSearchShimmer() }
            Status.SUCCESS -> {
                Log.d(DEBUG, categories.data.toString())
                categories.data?.let { CategoriesList(it, navController, mainViewModel) }
            }
            Status.ERROR -> {
                Log.e(ERROR, categories.data.toString())
                NoResults(navController = navController)
            }
        }
    }

}