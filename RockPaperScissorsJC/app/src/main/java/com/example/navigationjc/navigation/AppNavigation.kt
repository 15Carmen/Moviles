package com.example.navigationjc.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationjc.screens.FirstScreen
import com.example.navigationjc.screens.SecondScren


@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.FirstScreen.route){
        composable(route = AppScreens.FirstScreen.route){
            FirstScreen(navController)
        }
        composable(route = AppScreens.SecondScreen.route){
            SecondScren(navController)
        }
    }

}