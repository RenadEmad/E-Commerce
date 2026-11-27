package com.example.kotlin.ui.feature.auth.domain.use_case

import com.example.kotlin.ui.feature.auth.data.repo.AuthRepo
import com.example.kotlin.ui.feature.auth.domain.entity.login.LoginRequest
import com.example.kotlin.ui.feature.network.utility.ApiResult
import javax.inject.Inject

class LoginUseCase @Inject constructor (val authRepo: AuthRepo) {

suspend fun invoke(loginRequest: LoginRequest):ApiResult<Unit> = authRepo.login(loginRequest )


}