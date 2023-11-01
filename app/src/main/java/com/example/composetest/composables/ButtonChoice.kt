package com.example.composetest.composables

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun ButtonChoice(
    text:String,
    index:Int,
    animationStart:Int,
    selected:Int,
    clickable:Boolean,
    animate:Boolean,
    onClick:(Int)->Unit,
    changeAnimationState:(Int)->Unit,
    changeAnimationArray:(Int)->Unit,
    unClickable:()->Unit,
    modifier:Modifier=Modifier,
){

    val backgroundColor by animateColorAsState(
        targetValue = updateColor(selected),
        tween(500),
        label = "",
    )

    AnimatedVisibility(
        visible = (animate),
        enter = scaleIn(animationSpec = tween(250)),
        exit = scaleOut(animationSpec = tween(250)),
    ) {
        Button(
            modifier = modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = backgroundColor, disabledContainerColor = backgroundColor),
            onClick = { onClick(index)},
            enabled = clickable,
        ) {
            Text(
                text = text,
                color = Color.Black,
                maxLines = 1,
            )
        }
    }
    if(selected==1){
        LaunchedEffect(key1 = true){
            unClickable()
            changeAnimationState(0)
        }
    }
    if(animationStart==index){
        LaunchedEffect(key1 = true){
            delay(250)
            changeAnimationArray(animationStart)
            changeAnimationState(animationStart+1)
        }
    }
}

fun updateColor(selected:Int):Color{
    return if (selected!=-1){
        if(selected==1){
            Color.Green
        }else{
            Color.Red
        }
    }else {
        Color.White
    }
}