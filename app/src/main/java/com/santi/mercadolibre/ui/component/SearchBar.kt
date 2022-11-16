package com.santi.mercadolibre.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.santi.mercadolibre.viewmodels.MainViewModel


@Composable
fun SearchBar(
    mainViewModel: MainViewModel
) {
    val keyword: String by mainViewModel.keyword.observeAsState(initial = "")
    TextField(
        value = keyword,
        onValueChange = { mainViewModel.getSearch(it) },
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