package com.santi.mercadolibre.ui.component

import android.content.res.Configuration
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//Componente Shimmer del detalle del Producto
@Preview(showSystemUi = true)
@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DetailShimmer() {

    val gradient = listOf(
        Color.LightGray.copy(alpha = 0.9f),
        Color.LightGray.copy(alpha = 0.3f),
        Color.LightGray.copy(alpha = 0.9f)
    )

    val transition = rememberInfiniteTransition()

    val translateAnimation = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutLinearInEasing
            )
        )
    )
    val brush = linearGradient(
        colors = gradient,
        start = Offset(200f, 200f),
        end = Offset(
            x = translateAnimation.value,
            y = translateAnimation.value
        )
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
            .padding(all = 10.dp)
    ) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clip(RoundedCornerShape(10.dp))
                .padding(bottom = 10.dp)
                .background(brush)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Spacer(
            modifier = Modifier
                .height(20.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth(fraction = 0.5f)
                .background(brush)
        )

        Spacer(modifier = Modifier.height(10.dp))
        Spacer(
            modifier = Modifier
                .height(20.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth(fraction = 0.7f)
                .background(brush)
        )

        Spacer(modifier = Modifier.height(10.dp))
        Spacer(
            modifier = Modifier
                .height(20.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth(fraction = 0.9f)
                .background(brush)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Spacer(
            modifier = Modifier
                .height(20.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth(fraction = 0.5f)
                .background(brush)
        )

        Spacer(modifier = Modifier.height(10.dp))
        Spacer(
            modifier = Modifier
                .height(20.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth(fraction = 0.7f)
                .background(brush)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Spacer(
            modifier = Modifier
                .height(20.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth(fraction = 0.9f)
                .background(brush)
        )
    }
}