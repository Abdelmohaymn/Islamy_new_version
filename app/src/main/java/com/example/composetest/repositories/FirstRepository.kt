package com.example.composetest.repositories

import android.content.Context
import com.example.composetest.Constants
import com.example.composetest.models.FirstGame
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import javax.inject.Inject

class FirstRepository @Inject constructor(
    override var context: Context
) :MainRepository<FirstGame>() {
    override suspend fun getALLQuestions(): ArrayList<FirstGame> {
        val questions:ArrayList<FirstGame> = ArrayList()
        withContext(Dispatchers.IO){
            val job = async { getJsonArrayFromFile(Constants.FIRST_GAME) }
            val jsonArray: JSONArray? = job.await()
            if (jsonArray != null) {
                for (i in 0 until jsonArray.length()) {
                    val jsonObject = jsonArray.getJSONObject(i)
                    val ans1=jsonObject.getString("Ans1")
                    val ans2=jsonObject.getString("Ans2")
                    val ans3=jsonObject.getString("Ans3")
                    val ans4=jsonObject.getString("Ans4")
                    val correct=jsonObject.getString("Correct")
                    val ques = jsonObject.getString("Ques")
                    val choices = listOf(ans1,ans2,ans3,ans4)
                    questions.add(FirstGame(ques,choices,correct))
                }
            }
        }
        //val jsonArray: JSONArray? = getJsonArrayFromFile(Constants.FIRST_GAME)

        return questions
    }
}