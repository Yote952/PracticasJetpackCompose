package com.example.practicasjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.practicasjetpackcompose.ui.theme.PracticasJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticasJetpackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column{
                        MyTextFieldAdvance(
                            modifier = Modifier.padding(innerPadding)
                        )
                        MyTextField(modifier = Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}
@Composable
fun MyTextFieldAdvance(modifier: Modifier) {
    var myText by rememberSaveable { mutableStateOf("") }
    OutlinedTextField(
        value = myText,
        onValueChange = { myText = if (it.contains("a")){
                            it.replace("a","")
                            }
                            else{
                                it
                            }
                        },
        label = { Text(text = "Introduce tu nombre")},
        modifier = modifier,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Magenta,
            unfocusedBorderColor = Color.Blue
        )
    )
}
@Composable
fun MyTextField(modifier: Modifier) {
    var myText by rememberSaveable {mutableStateOf("")}
    TextField(value=myText, onValueChange = {myText = it})
}

@Composable
fun MyText(modifier: Modifier) {
    Column(Modifier.fillMaxSize()) {
        Text(text = "Esto es un ejemplo")
        Text(text = "Estp es un ejemplo", color = Color.Blue)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.ExtraBold)
        Text(text = "Esto es un ejemplo", fontWeight = FontWeight.Light)
        Text(text = "Esto es un ejemplo", fontFamily = FontFamily.Cursive)
        Text(text = "Esto es un ejemplo", textDecoration = TextDecoration.LineThrough)
        Text(text = "Esto es un ejemplo", textDecoration = TextDecoration.Underline)
        Text(text = "Esto es un ejemplo", textDecoration = TextDecoration.combine(listOf(
            TextDecoration.LineThrough,
            TextDecoration.Underline
        )))
        Text(text = "Esto es un ejemplo", fontSize = 30.sp)

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PracticasJetpackComposeTheme {
        MyTextFieldAdvance(Modifier)
    }
}