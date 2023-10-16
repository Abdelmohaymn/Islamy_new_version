package com.example.composetest.dataStore

interface DataPreferences {
    suspend fun putInteger(key:String, value:Int)
    suspend fun getInteger(key:String):Int?

    suspend fun putBoolean(key:String, value:Boolean)
    suspend fun getBoolean(key:String):Boolean?
}