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
import androidx.lifecycle.Observer
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
                PrincipalComponent(mainViewModel = mainViewModel)
            }
        }
        listener()
    }

    private fun listener() {
        mainViewModel.res.observe(this, Observer { response ->
            /*when (response.status) {
                Status.SUCCESS -> {
                    Log.d("Prueba", "Bien: $response")
                    products.value = response.data.results
                }
                Status.LOADING -> {

                }
                Status.ERROR -> {
                    Toast.makeText(this, "Error en la busqueda", Toast.LENGTH_LONG).show()
                }
            }*/
        })
    }
}

@Composable
fun PrincipalComponent(mainViewModel: MainViewModel) {
    val products by mainViewModel.products.observeAsState(initial = listOf())
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SearchBar(mainViewModel)
        ProductsList(products)
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