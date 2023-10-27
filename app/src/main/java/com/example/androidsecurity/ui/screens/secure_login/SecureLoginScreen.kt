package com.example.androidsecurity.ui.screens.secure_login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.androidsecurity.ui.components.ButtonField
import com.example.androidsecurity.ui.components.TextFormField
import com.example.androidsecurity.ui.theme.PurpleGrey80

@Composable
fun SecureLoginScreen() {
    val viewModel = hiltViewModel<SecureLoginScreenViewModel>()

    Column(
        Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        if (viewModel.isLoading.value) {
            CircularProgressIndicator(
                modifier = Modifier.size(35.dp),
                color = PurpleGrey80,
            )
        }

        TextFormField(
            value = viewModel.email.value,
            placeholder = "Username or Email",
            onValueChanged = { viewModel.email.value = it})
        Spacer(modifier = Modifier.height(15.dp))
        TextFormField(
            value = viewModel.password.value,
            placeholder = "Password",
            visualTransformation = PasswordVisualTransformation(),
            onValueChanged = {viewModel.password.value = it}
        )
        Spacer(modifier = Modifier.height(40.dp))
        ButtonField(
            label = "Get Token",
            onClick = {viewModel.onLoginClicked()},
            isLoading = viewModel.isLoading.value)

        Spacer(modifier = Modifier.height(15.dp))

        if(viewModel.token.value != "") {
            Text(
                text = "Token: ${viewModel.token.value}",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                ),
            )
        }
    }
}