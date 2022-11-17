package com.santi.mercadolibre.ui.component

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.santi.mercadolibre.models.ResponseResult
import com.santi.mercadolibre.navigation.AppScreens
import com.santi.mercadolibre.ui.theme.MercadoLibreTheme
import com.santi.mercadolibre.utils.imageConverter
import com.santi.mercadolibre.utils.toCurrencyString
import com.santi.mercadolibre.R

//Componente de los items de los productos
@Composable
fun ProductItemView(
    product: ResponseResult,
    navController: NavController
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clickable {
                navController.navigate(route = AppScreens.DetailScreen.route + "/${product.id}")
            }
    ) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(MaterialTheme.colors.onBackground)
        ) {
            AsyncImage(
                model = product.thumbnail.imageConverter(),
                contentDescription = stringResource(id = R.string.image_product),
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Column() {
            Text(
                product.title.toString(),
                color = MaterialTheme.colors.onBackground,
                maxLines = 2
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                product.price.toCurrencyString(),
                color = MaterialTheme.colors.onBackground
            )
        }
    }
}

//Componente de visualización
@Preview(showSystemUi = true)
@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview() {
    val product = ResponseResult(
        id = "0",
        title = "Celular",
        price = 2020202000,
        thumbnail = "Image",
    )
    val navController = rememberNavController()
    MercadoLibreTheme {
        ProductItemView(product, navController)
    }
}

