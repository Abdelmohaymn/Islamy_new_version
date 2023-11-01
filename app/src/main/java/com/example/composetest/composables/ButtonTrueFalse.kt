package com.example.composetest.composables

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ButtonTrueFalse(
    text:String,
    index:Int,
    selected:Int,
    clickable:Boolean,
    onClick:(Int)->Unit,
    modifier: Modifier = Modifier
){
    val backgroundColor by animateColorAsState(
        targetValue = updateColor(selected),
        tween(500),
        label = "",
    )

    Button(
        modifier=modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        onClick = {onClick(index)},
        enabled = clickable,
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor, disabledContainerColor = backgroundColor),
    ) {
        Text(
            text = text,
            color = Color.Black,
        )
    }
}

