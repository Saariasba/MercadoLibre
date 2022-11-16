package com.santi.mercadolibre

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.santi.mercadolibre.ui.component.SearchBar
import com.santi.mercadolibre.ui.theme.MercadoLibreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MercadoLibreTheme {
                DefaultPreview()
            }
        }
    }
}

class TextFieldState(){
    var text: String by mutableStateOf("")
}

@Composable
fun PrincipalComponent() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val searchState = remember { TextFieldState() }
        SearchBar(searchState)
        Text(text = searchState.text)

    }
}

@Preview(showSystemUi = true)
@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview() {
    MercadoLibreTheme {
        PrincipalComponent()
    }
}