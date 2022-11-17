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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.santi.mercadolibre.models.ResponseResult
import com.santi.mercadolibre.ui.theme.MercadoLibreTheme

@Composable
fun ProductItemView(
    product: ResponseResult
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clickable {  }
    ) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(MaterialTheme.colors.onBackground)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(product.thumbnail)
                    .transformations(CircleCropTransformation())
                    .build(),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Column() {
            Text(
                product.title.toString(),
                color = MaterialTheme.colors.onBackground
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                product.price.toString(),
                color = MaterialTheme.colors.onBackground
            )
        }
    }
}

@Preview(showSystemUi = true)
@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview() {
    val product = ResponseResult(
        id = "0",
        title = "Celular",
        price = "$ 202.0202.000",
        thumbnail = "Image",
    )

    MercadoLibreTheme {
        ProductItemView(product)
    }
}