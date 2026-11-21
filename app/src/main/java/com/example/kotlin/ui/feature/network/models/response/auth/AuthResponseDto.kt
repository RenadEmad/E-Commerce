package com.example.kotlin.ui.feature.network.models.response.auth


import com.google.gson.annotations.SerializedName

data class AuthResponseDto(
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("token")
    val token: String? = null,
    @SerializedName("user")
    val user: UserDto? = null
)