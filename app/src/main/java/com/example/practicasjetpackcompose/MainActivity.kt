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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
                    MyComplexLayout(
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
            modifier = Modifier.fillMaxWidth().weight(1f).background(Color.Cyan),
            contentAlignment = Alignment.Center
        ){
                Text("Ejemplo 1")
        }
        Spacer(Modifier.height(30.dp))
        Row(
            modifier = Modifier.fillMaxWidth().weight(1f)
        ){
            Box(
                modifier =  Modifier.weight(1f).fillMaxHeight().background(Color.Red),
                contentAlignment = Alignment.Center
            ){
                Text("Ejemplo 2")
            }
            Box(
                modifier =  Modifier.weight(1f).fillMaxHeight().background(Color.Green),
                contentAlignment = Alignment.Center
            ){
                Text("Ejemplo 3")
            }
        }
        Box(
            modifier = Modifier.fillMaxWidth().weight(1f).background(Color.Magenta),
            contentAlignment = Alignment.BottomCenter
        ){
                Text("Ejemplo 4")
        }
    }
}
@Composable
fun MyColumn(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Ejemplo 1", modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "Ejemplo 1", modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "Ejemplo 1", modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "Ejemplo 1", modifier = Modifier
            .background(Color.Black)
            .weight(1f))
        Text(text = "Ejemplo 1", modifier = Modifier.background(Color.Cyan))
        Text(text = "Ejemplo 1", modifier = Modifier.background(Color.Blue))
    }
}

@Composable
fun MyRow(modifier: Modifier) {
    Row(modifier = modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween){
        Text("Ejemplo", modifier = Modifier.width(100.dp))
        Text("Ejemplo", modifier = Modifier.width(100.dp))
        Text("Ejemplo", modifier = Modifier.width(100.dp))
        Text("Ejemplo", modifier = Modifier.width(100.dp))
        Text("Ejemplo", modifier = Modifier.width(100.dp))
        Text("Ejemplo", modifier = Modifier.width(100.dp))
        Text("Ejemplo", modifier = Modifier.width(100.dp))
        Text("Ejemplo", modifier = Modifier.width(100.dp))
    }
}

@Composable
fun MyBox(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .background(color = Color.Cyan)
                .verticalScroll(rememberScrollState())
        ) {
            Text("Esto es un Ejemplo")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PracticasJetpackComposeTheme {
        MyComplexLayout(Modifier)
    }
}