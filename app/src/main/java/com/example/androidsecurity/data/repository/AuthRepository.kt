package com.example.androidsecurity.data.repository

import com.example.androidsecurity.data.ApiService
import com.example.androidsecurity.data.models.DataState
import com.example.androidsecurity.data.models.TokenRequest
import com.example.androidsecurity.data.models.TokenResponse
import javax.inject.Inject
import kotlinx.coroutines.flow.*

class AuthRepository @Inject constructor(
    private val apiService: ApiService,
) : AuthRepositoryInterface {

    override fun getToken(email: String, password: String)
    : Flow<DataState<TokenResponse>> = flow {
        try {
            val body = TokenRequest(email, password)
            val res = apiService.getToken(body)
            emit(DataState.Success(res))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }
}