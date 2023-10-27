package com.example.androidsecurity.ui.screens.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.androidsecurity.ui.components.ButtonField
import com.example.androidsecurity.ui.components.TextFormField
import com.example.androidsecurity.ui.theme.PurpleGrey80
import androidx.compose.foundation.layout.Column as Column1

@Composable
@Preview
fun LoginScreen() {
    val viewModel = hiltViewModel<LoginScreenViewModel>()

    Column1(
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