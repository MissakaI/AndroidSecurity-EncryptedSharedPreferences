package com.example.androidsecurity.ui.screens.login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.androidsecurity.MainActivity
import com.example.androidsecurity.PREF_UN_SECURE_JWT_TOKEN
import com.example.androidsecurity.data.repository.AuthRepository
import com.example.androidsecurity.utils.SharedPreferenceHelper
import com.example.androidsecurity.utils.generateTokenLocalMethod
import com.example.androidsecurity.utils.showToast
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val pref: SharedPreferenceHelper,
    private val repository: AuthRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default
): ViewModel() {
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

        token.value = generateTokenLocalMethod(email.value, password.value) // Replace [generateTokenLocalMethod] with API response value

        // save in shared preferences
        pref.saveString(
            PREF_UN_SECURE_JWT_TOKEN,
            token.value
        )
        showToast(MainActivity.appContext, "Token saved in shared preferences")
        isLoading.value = false
    }

}