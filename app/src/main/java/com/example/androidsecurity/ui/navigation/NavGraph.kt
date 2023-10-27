package com.example.androidsecurity.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.androidsecurity.HOME_SCREEN_ROUTE
import com.example.androidsecurity.KEYSTORE_SCREEN_ROUTE
import com.example.androidsecurity.SHARED_PREF_SCREEN_ROUTE
import com.example.androidsecurity.ui.screens.home.HomeScreen
import com.example.androidsecurity.ui.screens.login.LoginScreen
import com.example.androidsecurity.ui.screens.secure_login.SecureLoginScreen

@Composable
fun NavGraph(
    navController: NavHostController,
) {

    NavHost(
        navController = navController,
        startDestination = HOME_SCREEN_ROUTE,
        modifier = Modifier.fillMaxSize()
    ) {
        addHomeScreen(navController, this)
        addKeyStoreScreen(navController, this)
        addSharedPrefScreen(navController, this)
    }
}

private fun addHomeScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = HOME_SCREEN_ROUTE) {
        HomeScreen(navController = navController)
    }
}

private fun addKeyStoreScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = KEYSTORE_SCREEN_ROUTE) {
        SecureLoginScreen()
    }
}

private fun addSharedPrefScreen(
    navController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(route = SHARED_PREF_SCREEN_ROUTE) {
        LoginScreen()
    }
}

@Composable
fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route?.substringBeforeLast("/")
}

@Composable
fun navigationTitle(navController: NavController): String {
    return when (currentRoute(navController)) {
        HOME_SCREEN_ROUTE -> "Choose Your Device"
        KEYSTORE_SCREEN_ROUTE -> "Save the token in Keystore"
        SHARED_PREF_SCREEN_ROUTE -> "Save the token in Shared preferences"
        else -> ""
    }
}
