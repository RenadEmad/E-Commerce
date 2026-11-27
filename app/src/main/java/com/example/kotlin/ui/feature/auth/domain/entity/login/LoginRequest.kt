package com.example.kotlin.ui.feature.auth.domain.entity.login



data class LoginRequest(
    val email: String? = null,
    val password: String? = null
)