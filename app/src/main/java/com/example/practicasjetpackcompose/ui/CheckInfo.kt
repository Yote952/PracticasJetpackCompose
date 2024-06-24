package com.example.practicasjetpackcompose.ui

data class CheckInfo (val title:String, var seleted:Boolean = false, var onCheckChange:(Boolean)->Unit){
}