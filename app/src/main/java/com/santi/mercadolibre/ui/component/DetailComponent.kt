package com.santi.mercadolibre.ui.component

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.santi.mercadolibre.viewmodels.DetailViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.santi.mercadolibre.models.ProductResponse
import com.santi.mercadolibre.utils.DEBUG
import com.santi.mercadolibre.utils.ERROR
import com.santi.mercadolibre.utils.Status
import com.santi.mercadolibre.utils.toCurrencyString
import com.santi.mercadolibre.R

//Componente Principal del Detalle del Producto
@Composable
fun DetailComponent(navController: NavController, id: String?) {
    val detailViewModel = hiltViewModel<DetailViewModel>()
    detailViewModel.getProduct(id.toString())
    val product = detailViewModel.product.collectAsState().value
    when (product.status) {
        Status.LOADING -> DetailShimmer()
        Status.SUCCESS -> {
            Log.d(DEBUG, product.data.toString())
            product.data?.let { ProductView(it) }
        }
        Status.ERROR -> {
            Log.e(ERROR, product.data.toString())
            NoResults(navController = navController)
        }
    }
}

@Composable
fun ProductView(product: ProductResponse) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .background(MaterialTheme.colors.onBackground)
        ) {
            AsyncImage(
                model = product.pictures.firstOrNull()?.secure_url,
                contentDescription = stringResource(id = R.string.image_product),
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = product.title.toString(),
            color = MaterialTheme.colors.onBackground,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Left,
            maxLines = 2,
            modifier = Modifier
                .padding(start = 10.dp)
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = product.price.toCurrencyString(),
            color = MaterialTheme.colors.onBackground,
            fontSize = 20.sp,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .padding(start = 10.dp)
        )
    }
}

//Componente de visualización
@Preview(showSystemUi = true)
@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ProductViewPreview() {
    ProductView(product = ProductResponse(title = "Titulo", price = 200000))
}