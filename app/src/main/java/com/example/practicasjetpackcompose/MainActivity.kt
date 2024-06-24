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
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practicasjetpackcompose.ui.CheckInfo
import com.example.practicasjetpackcompose.ui.theme.PracticasJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val listCheck = getOpcions(titles = listOf("Yote", "Ejemplo", "Gato"))
            PracticasJetpackComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        MySwitch(Modifier.padding(innerPadding))
                        MyTriStatusCheckBox()
                        MyRadioButtonList()
                        listCheck.forEach {
                            MyCheckBoxWithText(
                                modifier = Modifier.padding(innerPadding),
                                checkInfo = it
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MyRadioButton() {
    var state by rememberSaveable {
        mutableStateOf(false)
    }
    Row(Modifier.fillMaxSize()) {
        RadioButton(
            selected = state,
            onClick = { state = !state },
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Green,
                unselectedColor = Color.Yellow,
                disabledSelectedColor = Color.DarkGray,
                disabledUnselectedColor = Color.Blue
            )
        )
        Text("Hola")
    }
}
@Composable
fun MyRadioButtonList(){
    var selected by rememberSaveable {
        mutableStateOf("Yote")
    }
    Column(Modifier.fillMaxSize()) {
        Row {
            RadioButton(
                selected = selected == "Yote",
                onClick = {selected = "Yote" }
                )
            Text("Yote")
        }
        Row {
            RadioButton(
                selected = selected == "Luis",
                onClick = {selected = "Luis" }

            )
            Text("Luis")
        }
        Row {
            RadioButton(
                selected = selected == "Fulanito",
                onClick = {selected = "Fulanito" }

            )
            Text("Fulanito")
        }
        Row {
            RadioButton(
                selected = selected == "Juan",
                onClick = {selected = "Juan" }

            )
            Text("Juan")
        }



    }
}

@Composable
fun MyTriStatusCheckBox() {
    var status by rememberSaveable {
        mutableStateOf(ToggleableState.Off)
    }
    TriStateCheckbox(state = status, onClick = {
        status = when (status) {
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })
}

@Composable
fun getOpcions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var status by rememberSaveable {
            mutableStateOf(false)
        }
        CheckInfo(
            title = it,
            seleted = status,
            onCheckChange = { status = it }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    var status by rememberSaveable {
        mutableStateOf(false)
    }
    val checkInfo = CheckInfo(
        title = "Ejemplo 1",
        seleted = status,
        onCheckChange = { status = it }
    )
    PracticasJetpackComposeTheme {
        MyCheckBoxWithText(Modifier, checkInfo)
    }
}

@Composable
fun MyCheckBoxWithText(modifier: Modifier, checkInfo: CheckInfo) {
    var state by rememberSaveable {
        mutableStateOf(true)
    }
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checkInfo.seleted,
            onCheckedChange = { checkInfo.onCheckChange(!checkInfo.seleted) })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = checkInfo.title, fontSize = 20.sp)
    }
}

@Composable
fun MyCheckBox(modifier: Modifier) {
    var state by rememberSaveable {
        mutableStateOf(true)
    }
    Checkbox(checked = state, onCheckedChange = { state = !state })
}

@Composable
fun MySwitch(modifier: Modifier) {
    var state by rememberSaveable {
        mutableStateOf(true)
    }
    Switch(
        checked = state,
        onCheckedChange = { state = !state },
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.Green,
            checkedTrackColor = Color.Cyan,
            uncheckedThumbColor = Color.Red,
            checkedBorderColor = Color.Black,
            uncheckedTrackColor = Color.Magenta
        )
    )
}
