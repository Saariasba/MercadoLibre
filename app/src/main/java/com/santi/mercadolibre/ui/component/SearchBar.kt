package com.santi.mercadolibre.ui.component

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.santi.mercadolibre.TextFieldState
import com.santi.mercadolibre.ui.theme.MercadoLibreTheme

@Composable
fun SearchBar(searchState: TextFieldState = remember { TextFieldState() }) {
    TextField(
        value = searchState.text,
        onValueChange = {
            searchState.text = it
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "emailIcon"
            )
        },
        placeholder = { Text(text = "Buscar en MercadoLibre") },
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.background)
    )
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun SearchBarPreview() {
    MercadoLibreTheme {
        var searchState = remember { TextFieldState() }
        SearchBar(searchState)
    }
}