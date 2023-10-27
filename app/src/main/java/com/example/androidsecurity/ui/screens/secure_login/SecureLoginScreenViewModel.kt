package com.example.androidsecurity.ui.screens.secure_login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.androidsecurity.MainActivity
import com.example.androidsecurity.utils.KeyStoreHelper
import com.example.androidsecurity.utils.generateTokenLocalMethod
import com.example.androidsecurity.utils.showToast
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SecureLoginScreenViewModel  @Inject constructor(
    private val keyStore : KeyStoreHelper
): ViewModel(){
    val isLoading: MutableState<Boolean> = mutableStateOf(false)

    val email: MutableState<String> = mutableStateOf("")
    val password: MutableState<String> = mutableStateOf("")
    val token: MutableState<String> = mutableStateOf("")

    fun onLoginClicked() {
        if(email.value.isEmpty() || password.value.isEmpty()) return
        isLoading.value = true
        // TODO Get Token from API
//        viewModelScope.launch {
//            val resState: DataState<TokenResponse> = withContext(dispatcher) {
//                repository.getToken(email.value, password.value).single()
//            }
//            when (resState) {
//                is DataState.Success -> {
//                    val data = resState.data?.token
//                    if (data != null) {
//                        token.value = data
//                    }
//                }
//                is DataState.Error -> showToast(MainActivity.appContext, "Error in getting token")
//            }
//        }

        token.value = generateTokenLocalMethod( // Replace with token from api
            email.value,
            password.value
        )

        saveInAndroidKeyStore(token.value)
        showToast(MainActivity.appContext, "Token saved in keystore")
        isLoading.value = false
    }

    private fun saveInAndroidKeyStore(token : String) {
        val cipherToken = keyStore.encrypt(token)
        keyStore.storeStringKey(cipherToken)
    }
}