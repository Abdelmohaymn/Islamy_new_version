package com.example.composetest.repositories

import android.content.Context
import com.example.composetest.Constants
import com.example.composetest.models.ThirdGame
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import org.json.JSONArray
import javax.inject.Inject

class ThirdRepository @Inject constructor
    (
    override var context: Context
) : MainRepository<ThirdGame>() {

    override suspend fun getALLQuestions(): ArrayList<ThirdGame> {
        val questions:ArrayList<ThirdGame> = ArrayList()
        withContext(Dispatchers.IO){
            val job =  async {getJsonArrayFromFile(Constants.THIRD_GAME)}
            val jsonArray: JSONArray? = job.await()
            if (jsonArray != null) {
                for (i in 0 until jsonArray.length()) {
                    val jsonObject = jsonArray.getJSONObject(i)
                    val a1=jsonObject.getString("A1")
                    val a2=jsonObject.getString("A2")
                    val a3=jsonObject.getString("A3")
                    val a4=jsonObject.getString("A4")
                    val a5=jsonObject.getString("A5")
                    val a6=jsonObject.getString("A6")
                    val a7=jsonObject.getString("A7")
                    val a8=jsonObject.getString("A8")
                    val a9=jsonObject.getString("A9")
                    val a10=jsonObject.getString("A10")
                    val correct=jsonObject.getString("Correct")
                    val ques = jsonObject.getString("Ques")
                    val choices = listOf(a10,a2,a8,a4,a5,a6,a7,a3,a9,a1).shuffled()
                    questions.add(ThirdGame(ques,correct,choices))
                }
            }
        }
        return questions
    }
}