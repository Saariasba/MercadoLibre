package com.santi.mercadolibre.navigation

sealed class AppScreens(val route: String){
    object HomeScreen: AppScreens("home_screens")
    object DetailScreen: AppScreens("detail_screens")
}
