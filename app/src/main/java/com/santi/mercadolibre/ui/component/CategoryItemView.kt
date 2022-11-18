package com.santi.mercadolibre.ui.component

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Colors
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.santi.mercadolibre.models.ResponseResult
import com.santi.mercadolibre.navigation.AppScreens
import com.santi.mercadolibre.ui.theme.MercadoLibreTheme
import com.santi.mercadolibre.utils.imageConverter
import com.santi.mercadolibre.utils.toCurrencyString
import com.santi.mercadolibre.R
import com.santi.mercadolibre.models.CategoriesResponse

//Componente de los items de los productos
@Composable
fun CategoryItemView(
    category: CategoriesResponse,
    navController: NavController
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clickable {
                //navController.navigate(route = AppScreens.DetailScreen.route + "/${product.id}")
            }
    ) {
        Column() {
            Spacer(
                modifier = Modifier
                    .height(5.dp)
                    .fillMaxWidth()
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    category.name.toString(),
                    color = MaterialTheme.colors.onBackground,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Icon(
                    Icons.Filled.ArrowForward, stringResource(id = R.string.arrow),
                    Modifier
                        .padding(end = 10.dp)
                )
            }
            Spacer(
                modifier = Modifier
                    .height(16.dp)
                    .fillMaxWidth()
            )
            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(Color.Gray)
            )
        }
    }
}

//Componente de visualización
@Preview(showSystemUi = true)
@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DefaultCategoryPreview() {
    MercadoLibreTheme {
        //CategoryItemView()
    }
}

