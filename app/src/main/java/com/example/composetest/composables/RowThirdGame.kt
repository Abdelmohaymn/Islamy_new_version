package com.example.composetest.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.StateFlow

@Composable
fun RowThirdGame(
    buttonFunction:(Int)->Unit,
    texts:List<String>,
    clickableArray:List<StateFlow<Boolean>>,
){

    LazyVerticalGrid(
        modifier = Modifier.border(2.dp, Color.White, RoundedCornerShape(8.dp)),
        columns = GridCells.Adaptive(minSize = 80.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp)
    ){
        itemsIndexed(
            items = texts,
        ){index,text->
            val clickable by clickableArray[index].collectAsState()
            ButtonThirdGame(
                onClick = buttonFunction,
                text = text,
                index = index,
                clickable,
            )
        }
    }
    /*Row(
        modifier = Modifier.fillMaxWidth()
    ){
        for (i in 0 until 5){
            Box(
                modifier = Modifier.weight(1f),
            ){
                ButtonThirdGame(
                    onClick = buttonFunction,
                    text = texts[i],
                )
            }
            if(i!=4) Spacer(modifier = Modifier.width(8.dp))
        }
    }*/
}