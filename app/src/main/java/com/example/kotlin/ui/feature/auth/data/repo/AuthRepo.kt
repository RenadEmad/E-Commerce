package com.example.kotlin.ui.feature.auth.data.repo

import com.example.kotlin.ui.feature.auth.domain.entity.login.LoginRequest
import com.example.kotlin.ui.feature.auth.domain.entity.login.register.RegisterRequest
import com.example.kotlin.ui.feature.network.utility.ApiResult

interface AuthRepo {
    suspend fun login(loginRequest: LoginRequest): ApiResult<Unit>
    suspend fun register(registerRequest: RegisterRequest): ApiResult<Unit>


}