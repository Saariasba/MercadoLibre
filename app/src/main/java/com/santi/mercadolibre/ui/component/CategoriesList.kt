package com.santi.mercadolibre.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.santi.mercadolibre.R
import com.santi.mercadolibre.models.CategoriesResponse
import com.santi.mercadolibre.viewmodels.MainViewModel

//Componente que lista las categorias
@Composable
fun CategoriesList(
    categories: List<CategoriesResponse>,
    navController: NavController,
    mainViewModel: MainViewModel
) {
    Text(
        text = stringResource(id = R.string.search_into_meli_category),
        color = MaterialTheme.colors.onBackground,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Left,
        maxLines = 2,
        modifier = Modifier
            .padding(vertical = 15.dp)
    )
    Spacer(
        modifier = Modifier
            .height(1.dp)
            .fillMaxWidth()
            .background(Color.Gray)
    )
    LazyColumn(modifier = Modifier.background(MaterialTheme.colors.background)) {
        items(categories) { category ->
            CategoryItemView(
                category = category,
                navController = navController,
                mainViewModel = mainViewModel
            )
        }
    }
}