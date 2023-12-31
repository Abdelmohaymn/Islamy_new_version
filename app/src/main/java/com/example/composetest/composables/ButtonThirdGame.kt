package com.example.composetest.composables

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetest.ui.theme.white_gray


@Composable
fun ButtonThirdGame(
    onClick:(Int)->Unit,
    text:String,
    index:Int,
    clickable:Boolean,
    modifier:Modifier = Modifier,
){

    val backgroundColor by animateColorAsState(
        targetValue = buttonColor(!clickable),
        tween(500),
        label = "",
    )

    Button(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor, disabledContainerColor = backgroundColor),
        onClick = { onClick(index) },
        enabled = clickable
    ) {
        Text(
            modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally),
            text = text,
            color = Color.Black,
            maxLines = 1,
        )
    }

}

private fun buttonColor(state:Boolean):Color{
    return if(state) white_gray else Color.White
}