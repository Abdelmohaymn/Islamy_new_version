package com.example.composetest.viewmodels


import androidx.lifecycle.viewModelScope
import com.example.composetest.Constants
import com.example.composetest.models.FirstGame
import com.example.composetest.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstViewModel @Inject constructor(
    override var repository: MainRepository<FirstGame>
) : MainViewModel<FirstGame>(
    FirstGame()
) {
    override var INDEX_GAME = Constants.FIRST_GAME_INDEX

    private val __animationStart = MutableStateFlow(-1)
    val animationStart = __animationStart.asStateFlow()

    private val __animationArray = Array(4) { MutableStateFlow(true) }
    val animationArray = __animationArray.map { it.asStateFlow() }


    init {
        initialization()
        for(i in 0..3){
            __isSelectedArray[i].value = getSelectedState(i)
            __isClickableArray[i].value = __isSelectedArray[i].value==-1
        }
    }

    fun onChoose(index:Int){
        __isClickableArray[index].value = false
        if(state.value.correct == state.value.choices[index]){
            __isSelectedArray[index].value = 1
        }else{
            __isSelectedArray[index].value = 0
            saveSelectedState(index,0)
        }
    }

     override fun nextQuestion(){
         super.nextQuestion()
         for(i in __isSelectedArray.indices){
             __isSelectedArray[i].value=-1
             saveSelectedState(i,-1)
         }
         __animationStart.value=-1
         viewModelScope.launch {
             for(i in __animationArray){
                 i.value=true
                 delay(250)
             }
         }
         for(i in __isClickableArray)i.value=true
    }

    fun changeAnimationStart(index: Int){
        __animationStart.value = index
    }
    fun changeAnimationArray(index: Int){
        __animationArray[index].value = false
    }

    fun unClickable(){
        for (i in __isClickableArray)i.value=false
    }

    private fun saveSelectedState(index:Int,value:Int){
        viewModelScope.launch {
            repository.putInteger(Constants.SELECTED_STATE_FIRST_GAME+index,value)
        }
    }

    private fun getSelectedState(index: Int):Int{
        var value = -1
        viewModelScope.launch {
            val job = async { repository.getInteger(Constants.SELECTED_STATE_FIRST_GAME+index)}
            value = job.await()?:-1
        }
        return value
    }

}