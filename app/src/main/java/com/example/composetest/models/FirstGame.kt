package com.example.composetest.models

data class FirstGame(
    var ques: String="",
    var choices:List<String> = List(4){""},
    var correct: String=""
)
