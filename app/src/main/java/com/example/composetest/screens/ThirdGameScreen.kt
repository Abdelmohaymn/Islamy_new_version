package com.example.composetest.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
import com.example.composetest.composables.ButtonQuestion
import com.example.composetest.composables.RowThirdGame
import com.example.composetest.models.ThirdGame
import com.example.composetest.viewmodels.ThirdViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun ThirdGameScreen(
    viewModel:ThirdViewModel = hiltViewModel()
){
    val state by viewModel.state.collectAsState()
    val resultText by viewModel.resultText.collectAsState()
    thirdGame(
        state,
        resultText,
        viewModel.isClickable,
        viewModel::buttonFunction,
        viewModel::undo,
    )
}

@Composable
private fun thirdGame(
    state:ThirdGame,
    resultText:String,
    clickableArray:List<StateFlow<Boolean>>,
    buttonFunction:(Int)->Unit,
    undo:()->Unit,
){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ){
            ButtonQuestion(
                function = {},
                text = state.ques
            )
            Spacer(modifier = Modifier.height(64.dp))
            Row (
                modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.CenterHorizontally),
            ){
                Icon(
                    modifier = Modifier.clickable { undo() },
                    imageVector = Icons.Default.Clear,
                    tint = Color.White,
                    contentDescription = "undo",
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = resultText,
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
            RowThirdGame(
                buttonFunction = buttonFunction,
                texts = state.choices,
                clickableArray = clickableArray,
            )
            Spacer(modifier = Modifier.height(32.dp))
            ButtonQuestion(
                text = "التالي",
                function = {},
            )
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun preview(){
    /*thirdGame(
        ThirdGame(),
        "",
        {}
    )*/
}