package com.example.practicasjetpackcompose.ui

import android.widget.HorizontalScrollView
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import kotlin.math.roundToInt

@Composable
fun BasicSlider() {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        var sliderPositions by rememberSaveable {
            mutableStateOf(0f)
        }
        Slider(value = sliderPositions, onValueChange = { sliderPositions = it })
        Text(text = "${(sliderPositions* 1000).roundToInt() /10}%")
    }
}
@Composable
fun AdvanceSlider(){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        var sliderPositions by rememberSaveable { mutableStateOf(0f) }
        //var completeValue by rememberSaveable { mutableStateOf("") }
        Slider(
            value = sliderPositions,
            onValueChange = { sliderPositions = it },
            /*onValueChangeFinished = {
                completeValue = sliderPositions.toString()
            },*/
            valueRange = 0f..10f,
            steps = 9
            )
        Text(text = "$sliderPositions%")
    }
}