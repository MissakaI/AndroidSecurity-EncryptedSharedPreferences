package com.example.androidsecurity.ui.screens

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.compose.rememberNavController
import com.example.androidsecurity.HOME_SCREEN_ROUTE
import com.example.androidsecurity.KEYSTORE_SCREEN_ROUTE
import com.example.androidsecurity.SHARED_PREF_SCREEN_ROUTE
import com.example.androidsecurity.ui.components.AppBar
import com.example.androidsecurity.ui.navigation.NavGraph
import com.example.androidsecurity.ui.navigation.currentRoute

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val snackBarHostState = remember { SnackbarHostState() }
    val navController = rememberNavController()
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        snackbarHost = { SnackbarHost(snackBarHostState) },
        topBar = {
            when (currentRoute(navController)) {
                SHARED_PREF_SCREEN_ROUTE -> {
                    AppBar(
                        "Save the token in Shared preferences",
                    ) {
                        navController.popBackStack()
                    }
                }
                KEYSTORE_SCREEN_ROUTE -> {
                    AppBar(
                        "Save the token in Keystore",
                    ) {
                        navController.popBackStack()
                    }
                }
                HOME_SCREEN_ROUTE -> {
                    AppBar(
                        "Select a method to save the token", false
                    ) {
                        navController.popBackStack()
                    }
                }
            } },
        content = { NavGraph(navController) }
    )
}