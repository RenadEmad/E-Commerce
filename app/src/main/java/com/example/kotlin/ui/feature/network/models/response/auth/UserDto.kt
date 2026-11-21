package com.example.kotlin.ui.feature.network.models.response.auth


import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("role")
    val role: String? = null
)