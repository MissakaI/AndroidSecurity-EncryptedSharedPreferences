package com.example.androidsecurity.data.models

import com.google.gson.annotations.SerializedName

data class TokenRequest(
    @SerializedName("Email")
    val email: String,
    @SerializedName("Password")
    val password: String
)

data class TokenResponse(
    @SerializedName("Token")
    val token: String
)