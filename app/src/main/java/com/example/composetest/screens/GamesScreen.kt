package com.example.composetest.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composetest.composables.ButtonChoice
import com.example.composetest.composables.ButtonQuestion

@Composable
fun GamesScreen(
    navController: NavController
){
    gamesScreen(
        navigateToFirst = {navController.navigate(Screens.FirstGameScreen.route)},
        navigateToSecond =  { navController.navigate(Screens.SecondGameScreen.route) },
        navigateToThird = { navController.navigate(Screens.ThirdGameScreen.route) },

    )
}

@Composable
private fun gamesScreen(
    navigateToFirst:()->Unit,
    navigateToSecond:()->Unit,
    navigateToThird:()->Unit,
){
    Column(
        modifier=Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ){
        Column (
            modifier= Modifier
                .fillMaxSize()
                .padding(16.dp)
        ){
            Box (
                modifier = Modifier.weight(1f)
            ){
                ButtonQuestion(function = { navigateToFirst() }, text = "First")
            }
            Box (
                modifier = Modifier.weight(1f)
            ){
                ButtonQuestion(function = { navigateToSecond() }, text = "Second")
            }
            Box (
                modifier = Modifier.weight(1f)
            ){
                ButtonQuestion(function = { navigateToThird() }, text = "Third")
            }

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun preview(){
    gamesScreen(
        {},{},{},
    )
}