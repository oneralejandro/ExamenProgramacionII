package com.example.cobros.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cobros.view.AgregarView
import com.example.cobros.view.InicioView
import com.example.cobros.viewmodels.CobrosViewModel

@Composable
fun NavManager(viewModel: CobrosViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "inicio" ){
        composable("inicio"){
            InicioView(navController,viewModel)
        }
        composable("agregar"){
            AgregarView(navController,viewModel)
        }
    }
    
}
