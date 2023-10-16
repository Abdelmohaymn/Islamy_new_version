package com.example.composetest.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composetest.composables.ButtonChoice
import com.example.composetest.composables.ButtonQuestion
import com.example.composetest.models.SecondGame
import com.example.composetest.ui.theme.dark_gray
import com.example.composetest.ui.theme.white_gray
import com.example.composetest.viewmodels.SecondViewModel


@Composable
fun SecondGameScreen(
    viewModel: SecondViewModel = hiltViewModel()
){
    val state by viewModel.state.collectAsState()
    secondScreen(
        state,
        {}
    )
}

@Composable
private fun secondScreen(
    state:SecondGame,
    func:()->Unit
){
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(dark_gray)
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            ButtonQuestion(
                text = state.ques,
                function = {},
            )
        }
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
private fun previewSecondGameScreen(){
    secondScreen(
        SecondGame("Hello"),
        {}
    )
}