package com.example.composetest.viewmodels

import com.example.composetest.Constants
import com.example.composetest.models.ThirdGame
import com.example.composetest.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class ThirdViewModel @Inject constructor(
    override var repository: MainRepository<ThirdGame>
) : MainViewModel<ThirdGame>(
    ThirdGame()
) {
    override var INDEX_GAME = Constants.THIRD_GAME_INDEX


    init {
        initialization()
    }

    override fun checkIsCorrect(answer:String) {
        TODO("Not yet implemented")
    }

}