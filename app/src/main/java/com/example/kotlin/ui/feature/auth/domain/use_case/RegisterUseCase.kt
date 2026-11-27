package com.example.kotlin.ui.feature.auth.domain.use_case

import com.example.kotlin.ui.feature.auth.data.repo.AuthRepo
import com.example.kotlin.ui.feature.auth.domain.entity.login.register.RegisterRequest
import com.example.kotlin.ui.feature.network.utility.ApiResult
import javax.inject.Inject

class RegisterUseCase @Inject constructor (val authRepo: AuthRepo) {

suspend fun invoke(registerRequest: RegisterRequest):ApiResult<Unit> = authRepo.register(registerRequest )


}