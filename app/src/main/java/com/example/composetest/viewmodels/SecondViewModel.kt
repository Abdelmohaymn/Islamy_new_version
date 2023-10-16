package com.example.composetest.viewmodels


import com.example.composetest.Constants
import com.example.composetest.models.SecondGame
import com.example.composetest.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class SecondViewModel @Inject constructor
    (
    override var repository: MainRepository<SecondGame>,
) :MainViewModel<SecondGame>(SecondGame()) {
    override var INDEX_GAME = Constants.SECOND_GAME_INDEX


    init {
        initialization()
    }

    override fun checkIsCorrect(answer:String) {
        TODO("Not yet implemented")
    }


}