package com.santi.mercadolibre

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.santi.mercadolibre.navigation.AppNavigation
import com.santi.mercadolibre.ui.component.ProductsList
import com.santi.mercadolibre.ui.component.SearchBar
import com.santi.mercadolibre.ui.theme.MercadoLibreTheme
import com.santi.mercadolibre.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

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

@Composable
fun PrincipalComponent(navController: NavController, mainViewModel: MainViewModel) {
    val products by mainViewModel.products.observeAsState(initial = listOf())
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SearchBar(mainViewModel)
        ProductsList(products, navController)
    }
}

@Preview(showSystemUi = true)
@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview() {
    MercadoLibreTheme {
        //SearchBar(MainViewModel())
    }
}