package com.example.androidsecurity.utils

import android.content.Context
import android.widget.Toast
import com.example.androidsecurity.JWT_TOKEN_SECRET
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm

fun showToast(context : Context, message: String) {
    Toast.makeText( context,message,
        Toast.LENGTH_LONG).show();
}

// Generate token local
// Temporary function
fun generateTokenLocalMethod(email : String, password : String) :String {
    // Create a new JwtBuilder object.
    val builder = Jwts.builder()
    builder.claim("email", email)
    builder.claim("password", password)

    // Sign the token.
    builder.signWith(SignatureAlgorithm.HS256, JWT_TOKEN_SECRET)

    // Get the compact representation of the token.
    val token = builder.compact()
    return  token.toString()
}