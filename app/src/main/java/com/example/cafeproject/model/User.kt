package com.example.cafeproject.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("login")
    val login: String
)

data class Auth(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)

data class Token(
    @SerializedName("token")
    val token: String
)
