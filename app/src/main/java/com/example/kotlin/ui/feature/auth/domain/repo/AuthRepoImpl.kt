package com.example.kotlin.ui.feature.auth.domain.repo

import android.util.Log
import com.example.kotlin.ui.core.Navigation.errors.AppErrors
import com.example.kotlin.ui.feature.auth.data.data_source.remote.AuthRemoteDataSource
import com.example.kotlin.ui.feature.auth.data.mappers.toLoginRequestDto
import com.example.kotlin.ui.feature.auth.data.mappers.toRegisterRequestDto
import com.example.kotlin.ui.feature.auth.data.repo.AuthRepo
import com.example.kotlin.ui.feature.auth.domain.entity.login.LoginRequest
import com.example.kotlin.ui.feature.auth.domain.entity.login.register.RegisterRequest
import com.example.kotlin.ui.feature.commerce.data.data_sources.local.AuthLocalDataSource
import com.example.kotlin.ui.feature.network.models.response.auth.AuthResponseDto
import com.example.kotlin.ui.feature.network.utility.ApiResult
import javax.inject.Inject

class AuthRepoImpl @Inject constructor (
    val authRemoteDataSource: AuthRemoteDataSource
,val authLocalDataSource: AuthLocalDataSource
): AuthRepo {
    override suspend fun login(loginRequest: LoginRequest): ApiResult<Unit> {

       return when(val result=authRemoteDataSource.login(loginRequestDto = loginRequest.toLoginRequestDto())){
            is ApiResult.ErrorApiResult -> ApiResult.ErrorApiResult(error = AppErrors.ServerError(message = result.error.errorMessage))
            is ApiResult.SuccessApiResult<AuthResponseDto> -> {
                val token= result.data?.token
                if(!token.isNullOrBlank())
                {
authLocalDataSource.saveToken(token=token)
                }
                Log.e("T","token:  $token")

ApiResult.SuccessApiResult(data = Unit)

            }
        }
    }




    override suspend fun register(registerRequest: RegisterRequest): ApiResult<Unit> {
        return when(val result=authRemoteDataSource.register(registerRequestDto = registerRequest.toRegisterRequestDto())){
            is ApiResult.ErrorApiResult -> ApiResult.ErrorApiResult(error = AppErrors.ServerError(message = result.error.errorMessage))
            is ApiResult.SuccessApiResult<AuthResponseDto> -> {

                val token=result.data?.token
                if(!token.isNullOrBlank()){
                    authLocalDataSource.saveToken(token=token)
                }
Log.e("T","token:  $token")
                ApiResult.SuccessApiResult(data = Unit)

            }
        }
    }


}

