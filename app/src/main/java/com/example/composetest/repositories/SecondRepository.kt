package com.example.composetest.repositories

import android.content.Context
import com.example.composetest.Constants
import com.example.composetest.models.SecondGame
import org.json.JSONArray
import javax.inject.Inject

class SecondRepository @Inject constructor
    (
    override var context: Context
) : MainRepository<SecondGame>(){

    override suspend fun getALLQuestions(): ArrayList<SecondGame> {
        val questions:ArrayList<SecondGame> = ArrayList()
        val jsonArray: JSONArray? = getJsonArrayFromFile(Constants.SECOND_GAME)
        if (jsonArray != null) {
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                val ans=jsonObject.getString("Ans")
                val correct=jsonObject.getString("Correct")
                val ques = jsonObject.getString("Ques")
                questions.add(SecondGame(ques,ans,correct))
            }
        }
        return questions
    }


}