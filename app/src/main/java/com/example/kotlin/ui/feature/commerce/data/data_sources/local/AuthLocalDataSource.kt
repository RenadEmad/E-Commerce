package com.example.kotlin.ui.feature.commerce.data.data_sources.local

import kotlinx.coroutines.flow.Flow

interface AuthLocalDataSource {
val tokenFLow: Flow<String?>
suspend fun saveToken(token:String)
suspend fun removeToken()


    val isFirstTime:Flow<Boolean>
    suspend fun setFirstTimeCompleted()


}