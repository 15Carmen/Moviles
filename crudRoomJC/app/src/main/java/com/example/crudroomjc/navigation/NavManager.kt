package com.example.crudroomjc.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.crudroomjc.viewmodels.UsuariosViewModel
import com.example.crudroomjc.views.AgregarView
import com.example.crudroomjc.views.EditarView
import com.example.crudroomjc.views.InicioView

@Composable
fun NavManager(viewModel: UsuariosViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "inicio") {
        composable("inicio") {
            InicioView(navController, viewModel)
        }

        composable("agregar") {
            AgregarView(navController, viewModel)
        }

        composable("editar/{id}/{usuario}/{email}", arguments = listOf(
            navArgument("id") { type = NavType.IntType },
            navArgument("usuario") { type = NavType.StringType },
            navArgument("email") { type = NavType.StringType }

        )) {
            EditarView(navController, viewModel,
                it.arguments!!.getInt("id"),
                it.arguments?.getString("usuario"),
                it.arguments?.getString("email"))
        }
    }
}