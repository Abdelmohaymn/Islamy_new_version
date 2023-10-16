package com.example.composetest.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RowThirdGame(
    function:()->Unit,
    texts:List<String>
){

    Row(
        modifier = Modifier.fillMaxWidth()
    ){
        for (i in 0 until 5){
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ){
                //ButtonChoice(8,function = { function() }, text = texts[i])
            }
        }
    }
}