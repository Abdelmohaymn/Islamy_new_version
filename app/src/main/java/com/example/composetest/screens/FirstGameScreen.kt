package com.example.composetest.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composetest.composables.ButtonChoice
import com.example.composetest.composables.ButtonQuestion
import com.example.composetest.models.FirstGame
import com.example.composetest.ui.theme.dark_gray
import com.example.composetest.viewmodels.FirstViewModel
import kotlinx.coroutines.flow.StateFlow

lateinit var s:FirstGame

@Composable
fun FirstGameScreen(
    viewModel:FirstViewModel = hiltViewModel()
){
    val state by viewModel.state.collectAsState()
    val isCorrect by viewModel.correctState.collectAsState()
    val animationStart by viewModel.animationStart.collectAsState()

    s=state
    firstScreen(
        state,
        isCorrect,
        animationStart,
        viewModel.animationArray,
        viewModel.isSelected,
        viewModel.isClickable,
        viewModel::onChoose,
        viewModel::nextQuestion,
        viewModel::changeAnimationStart,
        viewModel::changeAnimationArray,
        viewModel::unClickable,
    )
}

@Composable
private fun firstScreen(
    state:FirstGame,
    isCorrect:Int,
    animationState:Int,
    animationArray:List<StateFlow<Boolean>>,
    isSelected:List<StateFlow<Boolean>>,
    isClickable:List<StateFlow<Boolean>>,
    onClick:(Int)->Unit,
    nextQues:()->Unit,
    changeAnimationState:(Int)->Unit,
    changeAnimationArray: (Int) -> Unit,
    unClickable:()->Unit,
){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(dark_gray)
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            ButtonQuestion(
                text = state.ques,
                function = {},
            )
            Spacer(modifier = Modifier.weight(1f))
            for(i in 0 until  4){
                val selectedState by isSelected[i].collectAsState()
                val animate by animationArray[i].collectAsState()
                val clickable by isClickable[i].collectAsState()
                Box (
                    modifier = Modifier.weight(1f)
                ){
                    ButtonChoice(
                        onClick = onClick, text = state.choices[i],
                        correct = isCorrect ,selected = selectedState, index = i,
                        animationStart = animationState,animate = animate,
                        changeAnimationState = changeAnimationState,
                        changeAnimationArray = changeAnimationArray,
                        clickable = clickable,
                        unClickable = unClickable,
                    )

                }

            }
            if(animationState==4){
                nextQues()
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
private fun preview(){
    /*firstScreen(
        s,
        {},
    )*/
}