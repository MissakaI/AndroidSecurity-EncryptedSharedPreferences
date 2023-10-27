package com.example.androidsecurity.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFormField(
    value: String,
    placeholder: String,
    onValueChanged:(String) -> Unit,
    visualTransformation : VisualTransformation = VisualTransformation.None,) {
    TextField(
        value = value,
        onValueChange = onValueChanged,
        modifier = Modifier
            .fillMaxWidth()
            .alpha(0.8f)
            .background(color = androidx.compose.ui.graphics.Color.White, shape = RoundedCornerShape(6.dp))
            .testTag("TextFormField"),
        shape = RoundedCornerShape(6.dp),
        placeholder = {
            Text(text = placeholder, fontSize = 14.sp)
        },
        singleLine = true,
        keyboardOptions  = KeyboardOptions(keyboardType = KeyboardType.Text),
        visualTransformation = visualTransformation
    )
}