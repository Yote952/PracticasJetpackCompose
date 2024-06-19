package com.example.practicasjetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practicasjetpackcompose.ui.theme.PracticasJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticasJetpackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyButtonExample(Modifier.padding(innerPadding))
                }
            }
        }
    }
}
@Composable
fun MyIcon(modifier: Modifier) {
    Icon(
        imageVector = Icons.Rounded.Star,
        contentDescription = "icono",
        tint = Color.Red
    )

}
@Composable
fun MyImageAdvance(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "ejemplo",
        modifier = Modifier
            .clip(CircleShape)
            .border(5.dp, Color.Red, CircleShape)
    )
}
@Composable
fun MyImage(modifier: Modifier) {
    Image(painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Ejemplo",
        alpha = 0.5f
    )
}
@Composable
fun MyButtonExample(modifier: Modifier) {
    var enable by rememberSaveable { mutableStateOf(true) }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            onClick = {
                enable = false
                Log.i("Yote", "Esto es un ejemplo")
            },
            enabled = enable,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta,
                contentColor = Color.White
            ),
            border = BorderStroke(5.dp, Color.Green)
        ) {
            Text("Button")
        }
        OutlinedButton(onClick = { /*TODO*/ },
            colors= ButtonDefaults.outlinedButtonColors(contentColor = Color.Blue, )) {
            Text("Lined Button")
        }
        TextButton(onClick = { /*TODO*/ }) {
            Text("Text Button")
        }
    }

}

@Composable
fun MyTextFieldAdvance(modifier: Modifier, name: String, onValueChanged: (String) -> Unit) {

    OutlinedTextField(
        value = name,
        onValueChange = { onValueChanged(it) },
        label = { Text(text = "Introduce tu nombre") },
        modifier = modifier,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Magenta,
            unfocusedBorderColor = Color.Blue
        )
    )
}

@Composable
fun MyTextField(modifier: Modifier) {
    var myText by rememberSaveable { mutableStateOf("") }
    TextField(value = myText, onValueChange = { myText = it })
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
        Text(
            text = "Esto es un ejemplo", textDecoration = TextDecoration.combine(
                listOf(
                    TextDecoration.LineThrough,
                    TextDecoration.Underline
                )
            )
        )
        Text(text = "Esto es un ejemplo", fontSize = 30.sp)

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PracticasJetpackComposeTheme {
        MyIcon(Modifier)
    }
}