package com.santi.mercadolibre.navigation

import com.santi.mercadolibre.utils.DETAIL_SCREEN
import com.santi.mercadolibre.utils.HOME_SCREEN

//Clase que define las Pantallas dentro de la aplicación
sealed class AppScreens(val route: String) {
    object HomeScreen : AppScreens(HOME_SCREEN)
    object DetailScreen : AppScreens(DETAIL_SCREEN)
}
