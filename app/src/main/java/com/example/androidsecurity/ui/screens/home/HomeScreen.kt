package com.example.androidsecurity.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.androidsecurity.ui.components.ButtonField

@Composable
fun HomeScreen(navController: NavHostController) {
    val viewModel = hiltViewModel<HomeScreenViewModel>()

    LaunchedEffect(true) {
        viewModel.init(navController)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        ButtonField(label = "KeyStore",
            onClick = { viewModel.onSecureLoginBtnClicked() }
        )
        Spacer(modifier = Modifier.height(10.dp))
        ButtonField(label = "Shared Preference",
            onClick = { viewModel.onSharedLoginBtnClicked() }
        )
    }
}