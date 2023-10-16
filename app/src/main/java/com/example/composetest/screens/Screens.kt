package com.example.composetest.screens

sealed class Screens(val route:String){
    object GamesScreen:Screens("gamesScreen")
    object FirstGameScreen:Screens("firstGameScreen")
    object SecondGameScreen:Screens("secondGameScreen")
    object ThirdGameScreen:Screens("thirdGameScreen")
}
