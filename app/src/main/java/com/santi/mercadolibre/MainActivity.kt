package com.santi.mercadolibre

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import com.santi.mercadolibre.ui.component.SearchBar
import com.santi.mercadolibre.ui.theme.MercadoLibreTheme
import com.santi.mercadolibre.utils.Status
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
        mainViewModel.res.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    Log.d("Prueba", "Bien: $it")
                }
                Status.LOADING -> {

                }
                Status.ERROR -> {
                    Toast.makeText(this, "Error en la busqueda", Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}

@Composable
fun PrincipalComponent(mainViewModel: MainViewModel) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SearchBar(mainViewModel)
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