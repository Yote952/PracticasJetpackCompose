package com.example.practicasjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicasjetpackcompose.ui.theme.PracticasJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticasJetpackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyStateExample(
                            modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MyComplexLayout(modifier: Modifier) {
    Column (
        modifier = modifier.fillMaxSize()
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan),
            contentAlignment = Alignment.Center
        ){
                Text("Ejemplo 1")
        }
        Spacer(Modifier.height(30.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ){
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Blue),
                contentAlignment = Alignment.Center
            ){
                Text("Ejemplo 2")
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green),
                contentAlignment = Alignment.Center
            ){
                Text("Ejemplo 3")
            }
        }
        Spacer(Modifier.height(50.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Magenta),
            contentAlignment = Alignment.BottomCenter
        ){
                Text("Ejemplo 4")
        }
    }
}
@Composable
fun MyStateExample(modifier: Modifier) {
    var counter by rememberSaveable {mutableStateOf(0)}
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(onClick = { counter++}){
            Text(text= "Pulsar")
        }
        Text(text = "He sido pulsaodo ${counter} veces")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PracticasJetpackComposeTheme {
        MyStateExample(Modifier)
    }
}