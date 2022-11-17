package com.santi.mercadolibre.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.santi.mercadolibre.R

//Vista que le ofrece retroalimentación (Generica), sobre algún error
@Composable
fun NoResults(navController: NavController) {
    Column(
        modifier = Modifier
            .padding(30.dp)
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
            .background(MaterialTheme.colors.background)
            .clip(shape = RoundedCornerShape(16.dp)),
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(350.dp)
                .border(
                    width = 4.dp,
                    color = MaterialTheme.colors.background,
                    shape = RoundedCornerShape(16.dp)
                )
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    stringResource(id = R.string.unexpected_error),
                    Modifier.padding(16.dp),
                    textAlign = TextAlign.Center,
                    style = typography.h4,
                    color = MaterialTheme.colors.onBackground
                )
                Button(
                    onClick = { navController.popBackStack() },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.onBackground,
                        contentColor = MaterialTheme.colors.background
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier.size(ButtonDefaults.IconSize)
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Text(stringResource(id = R.string.back))
                }
            }
        }
    }
}