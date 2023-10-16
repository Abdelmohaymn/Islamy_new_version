@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.composetest

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composetest.screens.FirstGameScreen
import com.example.composetest.screens.GamesScreen
import com.example.composetest.screens.Screens
import com.example.composetest.screens.SecondGameScreen
import com.example.composetest.screens.ThirdGameScreen
import com.example.composetest.ui.theme.ComposeTestTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun IslamyApp(){
    ComposeTestTheme {
        Scaffold {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Screens.GamesScreen.route){
                composable(Screens.GamesScreen.route){ GamesScreen(navController) }
                composable(Screens.FirstGameScreen.route){ FirstGameScreen()}
                composable(Screens.SecondGameScreen.route){ SecondGameScreen()}
                composable(Screens.ThirdGameScreen.route){ ThirdGameScreen()}
            }
        }
    }
}
