package com.santi.mercadolibre.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.santi.mercadolibre.PrincipalComponent
import com.santi.mercadolibre.ui.component.DetailComponent
import com.santi.mercadolibre.utils.ID_PRODUCT
import com.santi.mercadolibre.viewmodels.MainViewModel

//Componente que define la navegación dentro de la aplicación
@Composable
fun AppNavigation(mainViewModel: MainViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.HomeScreen.route) {
        composable(route = AppScreens.HomeScreen.route) {
            PrincipalComponent(navController, mainViewModel)
        }
        composable(
            route = AppScreens.DetailScreen.route + "/{id}",
            arguments = listOf(
                navArgument(name = ID_PRODUCT) {
                    type = NavType.StringType
                })
        ) {
            DetailComponent(navController, it.arguments?.getString(ID_PRODUCT))
        }
    }
}