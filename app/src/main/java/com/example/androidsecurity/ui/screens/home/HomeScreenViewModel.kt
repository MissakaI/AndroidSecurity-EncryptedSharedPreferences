package com.example.androidsecurity.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.androidsecurity.KEYSTORE_SCREEN_ROUTE
import com.example.androidsecurity.SHARED_PREF_SCREEN_ROUTE
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(): ViewModel(){
    private lateinit var navController: NavHostController

    fun init(controller: NavHostController) {
        navController = controller
    }


    fun onSecureLoginBtnClicked() {
        navController.navigate(KEYSTORE_SCREEN_ROUTE)
    }

    fun onSharedLoginBtnClicked() {
        navController.navigate(SHARED_PREF_SCREEN_ROUTE)
    }
}