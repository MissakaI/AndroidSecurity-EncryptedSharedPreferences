package com.example.androidsecurity.data

import com.example.androidsecurity.GENERATE_TOKEN
import com.example.androidsecurity.data.models.TokenRequest
import com.example.androidsecurity.data.models.TokenResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST(GENERATE_TOKEN)
    suspend fun getToken(
        @Body data: TokenRequest,
    ) : TokenResponse

}