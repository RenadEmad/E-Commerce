package com.example.kotlin.ui.feature.auth.data.mappers

import com.example.kotlin.ui.feature.auth.domain.entity.login.LoginRequest
import com.example.kotlin.ui.feature.network.models.request.auth.login.LoginRequestDto

fun LoginRequest.toLoginRequestDto():LoginRequestDto{
    return LoginRequestDto(
        password = this.password,
        email = this.email
    )
}