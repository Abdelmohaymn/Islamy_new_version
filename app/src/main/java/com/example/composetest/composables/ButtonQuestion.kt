package com.example.composetest.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ButtonQuestion(
    function:()->Unit,
    text:String,
    modifier: Modifier = Modifier,
){
    Button(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(Color.White),
        onClick = { function() },
    ) {
        Text(
            text = text,
            color = Color.Black,
            maxLines = 1,
        )
    }
}