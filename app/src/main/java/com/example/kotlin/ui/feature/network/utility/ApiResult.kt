package com.example.kotlin.ui.feature.network.utility

import com.example.kotlin.ui.core.Navigation.errors.AppErrors

sealed interface ApiResult<out T> {

 data class SuccessApiResult<T>   (val data : T?) : ApiResult<T>

    data class ErrorApiResult  (val error:AppErrors) : ApiResult<Nothing>



}