package com.example.composetest.viewmodels


import androidx.lifecycle.viewModelScope
import com.example.composetest.Constants
import com.example.composetest.models.SecondGame
import com.example.composetest.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SecondViewModel @Inject constructor
    (
    override var repository: MainRepository<SecondGame>,
) :MainViewModel<SecondGame>(SecondGame()) {
    override var INDEX_GAME = Constants.SECOND_GAME_INDEX

    private val __showCorrect = MutableStateFlow(false)
    val showCorrect = __showCorrect.asStateFlow()

    init {
        initialization()
    }

    fun checkIfCorrect(index:Int){
        //0 -> false ---- 1-> true
        for(i in __isClickableArray)i.value=false
        if(index==state.value.ans){
            __isSelectedArray[index].value=1
        }else{
            __isSelectedArray[index].value=0
        }
        if(state.value.correct!="")__showCorrect.value=true
    }

    override fun nextQuestion() {
        __showCorrect.value=false
        viewModelScope.launch { delay(100) }
        for(i in 0..1){
            __isSelectedArray[i].value=-1
            __isClickableArray[i].value=true
        }
        super.nextQuestion()
    }
}