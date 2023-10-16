package com.example.composetest.models

data class ThirdGame(
    var ques: String = "",
    var correct: String = "",
    var choices1:List<String> = List(5){""},
    var choices2:List<String> = List(5){""},

)