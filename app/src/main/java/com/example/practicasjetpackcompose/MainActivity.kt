package com.example.practicasjetpackcompose

import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practicasjetpackcompose.ui.AdvanceSlider
import com.example.practicasjetpackcompose.ui.BasicSlider
import com.example.practicasjetpackcompose.ui.CheckInfo
import com.example.practicasjetpackcompose.ui.theme.PracticasJetpackComposeTheme
import java.nio.file.WatchEvent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticasJetpackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        BasicSlider()
                        MyDivider()
                        AdvanceSlider()
                        MyDivider()
                        MyDropMenu()
                        MyDivider()
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {

    PracticasJetpackComposeTheme {
        MyDropMenu()
    }
}

@Composable
fun MyDivider(){
    Divider(modifier = Modifier.fillMaxWidth().padding(top = 5.dp))
}

@Composable
fun MyDropMenu(){
    var selectText by rememberSaveable { mutableStateOf("") }
    var expanded by rememberSaveable { mutableStateOf(false) }
    val desserts = listOf("Fruta","Cafe","Chocolate","Pie")
    Column {
        OutlinedTextField(
            value = selectText,
            onValueChange = {
                selectText = it
        },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true },
            colors = OutlinedTextFieldDefaults.colors(
                disabledTextColor = Color.White
            )
            )
        DropdownMenu(
            expanded = expanded, onDismissRequest = { expanded = false},
            modifier = Modifier.fillMaxWidth()
        ) {
            desserts.forEach { dessert ->
                DropdownMenuItem(text = {
                    Text(dessert)
                },
                    onClick = {
                        expanded = false
                        selectText = dessert
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBadgeBox(){
    BadgedBox(badge = {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.Red,
                contentColor = Color.White
            ),
        ){
            Text(text = "1000", modifier = Modifier.padding(3.dp))
        }
    }) {
        Icon(imageVector = Icons.Default.Star, contentDescription ="")
    }
}

@Composable
fun MyCard(modifier: Modifier) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Black,
            contentColor =  Color.White
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(14.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 12.dp,
            pressedElevation = 12.dp,
            draggedElevation = 13.dp
        ),
        shape = MaterialTheme.shapes.large
    ){
        Column(modifier = Modifier.padding(16.dp)){
            Text("ejemplo 1")
            Text("ejemplo 2")
            Text("ejemplo 3")
            Text("ejemplo 4")
        }
    }
}
