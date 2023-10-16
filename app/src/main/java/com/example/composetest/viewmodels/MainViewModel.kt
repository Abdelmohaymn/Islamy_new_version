package com.example.composetest.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composetest.repositories.MainRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch

abstract class MainViewModel <T>(initialValue:T): ViewModel() {

    protected abstract var repository:MainRepository<T>
    protected abstract var INDEX_GAME:String

    abstract fun checkIsCorrect(answer:String)

    private val __state = MutableStateFlow(initialValue)
    val state = __state.asStateFlow()

    private var index:Int=0
    private val questions : MutableList<T> = mutableListOf()

    protected fun initialization(){
        getAllQuestions()
    }


     private fun getAllQuestions(){
        viewModelScope.launch {
            val job1 = async { repository.getALLQuestions() }
            val job2 = async { repository.getInteger(INDEX_GAME) }
            val list:ArrayList<T> = job1.await()
            questions.addAll(list)
            index = job2.await()!!
            __state.value = questions[index]
        }
    }

     private fun getGameIndex(){
        viewModelScope.launch {
            val job = async { repository.getInteger(INDEX_GAME)}
            index = job.await()!!
            __state.value = questions[index]
        }
    }

    private fun setGameIndex(){
        viewModelScope.launch {
            repository.putInteger(INDEX_GAME,index)
        }
    }

     open fun nextQuestion(){
        index++
        __state.value = questions[index]
        setGameIndex()
    }

}