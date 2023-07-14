package xyz.imkaem.first_my_compose

import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun SomeTextScreen() {

    val textState: MutableState<String> = remember { mutableStateOf("") }

    TextField(
        value = textState.value,
        onValueChange = { newValue -> textState.value = newValue },
        label = { Text("Enter your name") }
    )
}