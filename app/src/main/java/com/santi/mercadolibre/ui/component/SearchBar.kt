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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import com.santi.mercadolibre.R
import com.santi.mercadolibre.viewmodels.MainViewModel

//Componente de la barra de busqueda principal
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
                contentDescription = stringResource(id = R.string.search_icon)
            )
        },
        textStyle = TextStyle(color = MaterialTheme.colors.onBackground),
        placeholder = {
            Text(
                text = stringResource(id = R.string.search_into_meli),
                color = MaterialTheme.colors.onBackground
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.background)
    )
}