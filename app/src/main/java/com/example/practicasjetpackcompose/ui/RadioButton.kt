package com.example.practicasjetpackcompose.ui


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun PreviewRadioButton(){
    MyRadioButton("Ejemplo 2", false){}
}
@Composable
fun MyRadioButton(text:String,selected:Boolean,onClick:()->Unit){
    Row(modifier = Modifier.background(Color.White).clickable { onClick() }, verticalAlignment = Alignment.CenterVertically){
        RadioButton(
            selected =selected,
            onClick = {},
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Blue,
                unselectedColor = Color.Black
            )
            )
        Text(
            text = text,
            color = Color.DarkGray,
            fontWeight = FontWeight.W600,
            fontSize = 15.sp
        )
    }
}