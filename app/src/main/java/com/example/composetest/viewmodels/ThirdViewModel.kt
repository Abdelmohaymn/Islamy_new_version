package com.example.composetest.viewmodels

import com.example.composetest.Constants
import com.example.composetest.models.ThirdGame
import com.example.composetest.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.Stack
import javax.inject.Inject

@HiltViewModel
class ThirdViewModel @Inject constructor(
    override var repository: MainRepository<ThirdGame>
) : MainViewModel<ThirdGame>(
    ThirdGame()
) {
    override var INDEX_GAME = Constants.THIRD_GAME_INDEX
    private val __resultText = MutableStateFlow("")
    val resultText = __resultText.asStateFlow()

    private val __correct = MutableStateFlow(false)
    val correct = __correct.asStateFlow()

    private val stack = Stack<Int>()

    init {
        initialization()
    }

    fun buttonFunction(index:Int){
        stack.push(index)
        __resultText.value+=state.value.choices[index]
        __isClickableArray[index].value = false
        if(__resultText.value == state.value.correct){
            __correct.value = true
        }
    }

    fun undo(){
        if(!stack.empty()){
            val index = stack.pop()
            val removeText = state.value.choices[index]
            __resultText.value = __resultText.value.removeSuffix(removeText)
            __isClickableArray[index].value = true
        }
    }

}