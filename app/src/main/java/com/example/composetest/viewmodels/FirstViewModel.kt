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

    private val __correctState = MutableStateFlow(-1)
    val correctState = __correctState.asStateFlow()

    private val __isSelectedArray = Array(4) { MutableStateFlow(false) }
    val isSelected = __isSelectedArray.map { it.asStateFlow() }

    private val __animationStart = MutableStateFlow(-1)
    val animationStart = __animationStart.asStateFlow()

    private val __animationArray = Array(4) { MutableStateFlow(true) }
    val animationArray = __animationArray.map { it.asStateFlow() }

    private val __isClickableArray = Array(4) { MutableStateFlow(true) }
    val isClickable = __isClickableArray.map { it.asStateFlow() }


    init {
        initialization()
        for(i in 0..3){
            __isSelectedArray[i].value=getSelectedState(i)
            __isClickableArray[i].value = !__isSelectedArray[i].value
        }
    }

    fun onChoose(index:Int){
        __isSelectedArray[index].value = true
        saveSelectedState(index,true)
        __isClickableArray[index].value = false
        if(state.value.correct == state.value.choices[index]){
            __correctState.value=index
        }
    }

    override fun checkIsCorrect(answer:String) {

    }

     override fun nextQuestion(){
         super.nextQuestion()
         for(i in __isSelectedArray.indices){
             __isSelectedArray[i].value=false
             saveSelectedState(i,false)
         }
         __correctState.value=-1
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

    private fun saveSelectedState(index:Int,value:Boolean){
        viewModelScope.launch {
            repository.putBoolean(Constants.SELECTED_STATE_FIRST_GAME+index,value)
        }
    }

    private fun getSelectedState(index: Int):Boolean{
        var value = false
        viewModelScope.launch {
            val job = async { repository.getBoolean(Constants.SELECTED_STATE_FIRST_GAME+index)}
            value = job.await()!!
        }
        return value
    }

}