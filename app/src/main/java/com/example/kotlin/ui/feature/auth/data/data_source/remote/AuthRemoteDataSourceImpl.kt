package com.example.kotlin.ui.feature.auth.data.data_source.remote

import com.example.kotlin.ui.feature.network.api.ApiServices
import com.example.kotlin.ui.feature.network.models.request.auth.login.LoginRequestDto
import com.example.kotlin.ui.feature.network.models.request.auth.register.RegisterRequestDto
import com.example.kotlin.ui.feature.network.models.response.auth.AuthResponseDto
import com.example.kotlin.ui.feature.network.utility.ApiResult
import com.example.kotlin.ui.feature.network.utility.SafeApiCall
import javax.inject.Inject

class AuthRemoteDataSourceImpl @Inject constructor(
    private val apiServices: ApiServices
) : AuthRemoteDataSource {

    override suspend fun login(loginRequestDto: LoginRequestDto): ApiResult<AuthResponseDto> =
        SafeApiCall {
            apiServices.login(loginRequest = loginRequestDto)
        }

    override suspend fun register(registerRequestDto: RegisterRequestDto): ApiResult<AuthResponseDto> =
        SafeApiCall {
            apiServices.register(registerRequest = registerRequestDto)
        }
}