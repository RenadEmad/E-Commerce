package com.example.kotlin.ui.feature.auth.data.mappers

import com.example.kotlin.ui.feature.auth.domain.entity.login.LoginRequest
import com.example.kotlin.ui.feature.auth.domain.entity.login.register.RegisterRequest
import com.example.kotlin.ui.feature.network.models.request.auth.login.LoginRequestDto
import com.example.kotlin.ui.feature.network.models.request.auth.register.RegisterRequestDto

fun RegisterRequest.toRegisterRequestDto(): RegisterRequestDto {
    return RegisterRequestDto(
       name = this.name,
        email = this.email,
        password = this.password,
        rePassword = this.rePassword,
        phone = this.phone
    )
}