//import com.example.kotlin.ui.feature.commerce.data.data_sources.local.AuthLocalDataSource
//import kotlinx.coroutines.flow.Flow
//import javax.inject.Inject
//
//class GitTokenUseCase @Inject constructor(
//    val authLocalDataSource: AuthLocalDataSource
//) {
//
//    suspend fun invoke() : Flow<String?> = authLocalDataSource.tokenFLow
//
//
//}

package com.example.kotlin.ui.feature.auth.domain.use_case

import com.example.kotlin.ui.feature.commerce.data.data_sources.local.AuthLocalDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GitTokenUseCase @Inject constructor(
    private val authLocalDataSource: AuthLocalDataSource
) {
    operator fun invoke(): Flow<String?> = authLocalDataSource.tokenFLow
}