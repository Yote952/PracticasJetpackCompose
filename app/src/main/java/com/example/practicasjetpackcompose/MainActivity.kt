package com.example.practicasjetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practicasjetpackcompose.ui.AdvanceSlider
import com.example.practicasjetpackcompose.ui.BasicSlider
import com.example.practicasjetpackcompose.ui.MyAlertDialog
import com.example.practicasjetpackcompose.ui.MySimpleCustomDialog
import com.example.practicasjetpackcompose.ui.theme.PracticasJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticasJetpackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var show by rememberSaveable {
                        mutableStateOf(false)
                    }
                    /*MyAlertDialog(show = show,onDismiss = {show = false}, onConfirm = {
                        Log.i("Yote", "Click")
                        show = false})
                    Column(modifier = Modifier.padding(innerPadding)) {
                        Button(onClick = {show = true}){
                            Text("Mostrar Dialogo")
                        }*/
                    MySimpleCustomDialog(show = show) { show = true }
                    Column(modifier = Modifier.padding(innerPadding)) {
                        BasicSlider()
                        MyDivider()
                        AdvanceSlider()
                        MyDivider()
                        MyDropMenu()
                        MyDivider()
                        Button(onClick = { show = true }) {
                            Text("Mostrar Dialogo")
                        }
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
fun MyDivider() {
    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp)
    )
}

@Composable
fun MyDropMenu() {
    var selectText by rememberSaveable { mutableStateOf("") }
    var expanded by rememberSaveable { mutableStateOf(false) }
    val desserts = listOf("Fruta", "Cafe", "Chocolate", "Pie")
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
            expanded = expanded, onDismissRequest = { expanded = false },
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
fun MyBadgeBox() {
    BadgedBox(badge = {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.Red,
                contentColor = Color.White
            ),
        ) {
            Text(text = "1000", modifier = Modifier.padding(3.dp))
        }
    }) {
        Icon(imageVector = Icons.Default.Star, contentDescription = "")
    }
}

@Composable
fun MyCard(modifier: Modifier) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Black,
            contentColor = Color.White
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
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("ejemplo 1")
            Text("ejemplo 2")
            Text("ejemplo 3")
            Text("ejemplo 4")
        }
    }
}