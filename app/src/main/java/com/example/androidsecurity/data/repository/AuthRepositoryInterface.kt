package com.example.androidsecurity.data.repository
import com.example.androidsecurity.data.models.DataState
import com.example.androidsecurity.data.models.TokenResponse
import kotlinx.coroutines.flow.Flow

interface AuthRepositoryInterface {
    fun getToken(email:String, password:String): Flow<DataState<TokenResponse>>
}