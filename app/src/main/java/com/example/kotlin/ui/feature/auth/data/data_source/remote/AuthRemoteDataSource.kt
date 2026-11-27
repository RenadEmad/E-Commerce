package com.example.kotlin.ui.feature.auth.data.data_source.remote

import com.example.kotlin.ui.feature.network.models.request.auth.login.LoginRequestDto
import com.example.kotlin.ui.feature.network.models.request.auth.register.RegisterRequestDto
import com.example.kotlin.ui.feature.network.models.response.auth.AuthResponseDto
import com.example.kotlin.ui.feature.network.utility.ApiResult

interface AuthRemoteDataSource {
    suspend fun login(loginRequestDto: LoginRequestDto) : ApiResult<AuthResponseDto>

    suspend fun register(registerRequestDto: RegisterRequestDto) : ApiResult<AuthResponseDto>
}