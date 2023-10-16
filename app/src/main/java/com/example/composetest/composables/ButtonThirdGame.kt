package com.example.composetest.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun ButtonThirdGame(
    function:()->Unit,
    text:String,
    modifier:Modifier = Modifier,
){
    Button(
        onClick = {function()},
        modifier = modifier.fillMaxSize()
    ){
        Text(text = text)
    }
}