package com.example.androidsecurity.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidsecurity.ui.theme.ButtonColor

@Composable
fun ButtonField(
    label: String,
    onClick: () -> Unit,
    isLoading: Boolean = false,) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(6.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = ButtonColor,
        ),
    ) {
        if (isLoading) {
            Box(Modifier.fillMaxWidth()) {
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp).testTag("progressIndicator"),
                    color = Color.White,
                )
            }
        } else {
            Text(
                text = label,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 16.sp,
                ),
            )
        }
    }
}