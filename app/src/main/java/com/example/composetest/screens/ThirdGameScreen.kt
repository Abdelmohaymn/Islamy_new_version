package com.example.composetest.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composetest.composables.ButtonChoice
import com.example.composetest.composables.RowThirdGame
import com.example.composetest.models.ThirdGame
import com.example.composetest.viewmodels.ThirdViewModel

@Composable
fun ThirdGameScreen(
    viewModel:ThirdViewModel = hiltViewModel()
){
    val state by viewModel.state.collectAsState()
    thirdGame(
        state,
        {},
    )
}

@Composable
private fun thirdGame(
    state:ThirdGame,
    function:()->Unit,
){
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ){
            /*ButtonChoice(
                radius = 8,
                function = { function() },
                text = state.ques
            )
            Spacer(modifier = Modifier.height(150.dp))
            Column(
                modifier = Modifier.weight(1f),
            ){
                RowThirdGame(function = {function()}, texts = state.choices1)
            }
            Column(
                modifier = Modifier.weight(1f)
            ){
                RowThirdGame(function = {function()}, texts = state.choices2)
            }
            Spacer(modifier = Modifier.height(16.dp))
            ButtonChoice(
                radius = 8,
                function = { function() },
                text = state.ques
            )*/
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun preview(){
    thirdGame(ThirdGame(),{})
}