package com.example.composetest.models

data class ThirdGame(
    var ques: String = "",
    var correct: String = "",
    var choices:List<String> = List(10){""},

)