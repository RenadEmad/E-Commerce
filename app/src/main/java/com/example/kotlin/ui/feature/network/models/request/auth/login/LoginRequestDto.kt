package com.example.kotlin.ui.feature.network.models.request.auth.login


import com.google.gson.annotations.SerializedName

data class LoginRequestDto(
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("password")
    val password: String? = null
)