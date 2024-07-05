package com.example.market.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainScreen(){
    var count by remember {
        mutableStateOf(0)
    }
    statefullComponent(count, onChange = {count++})
}
@Composable
fun statefullComponent(count:Int, onChange: () -> Unit){

    Column {
        Text(text = "Count number: $count")
        Button(onClick = onChange) {
            Text(text = "Data: $count")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun statePreview(){
    MainScreen()
}