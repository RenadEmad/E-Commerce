package com.example.kotlin.ui.feature.network.models.request.auth.register


import com.google.gson.annotations.SerializedName

data class RegisterRequestDto(
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("password")
    val password: String? = null,
    @SerializedName("phone")
    val phone: String? = null,
    @SerializedName("rePassword")
    val rePassword: String? = null
)