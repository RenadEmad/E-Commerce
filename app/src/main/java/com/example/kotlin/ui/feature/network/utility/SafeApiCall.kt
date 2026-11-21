package com.example.kotlin.ui.feature.network.utility

import com.example.kotlin.ui.core.Navigation.errors.AppErrors
import com.example.kotlin.ui.feature.network.models.response.response_error.CustomResponseError
import com.google.gson.Gson
import retrofit2.HttpException
import java.io.IOException

suspend fun<T> SafeApiCall (
    apiCall:suspend ()->T
):ApiResult<T>{
    try {
        return ApiResult.SuccessApiResult(data=apiCall())
    }
    catch (e: IOException){
        return ApiResult.ErrorApiResult(error = AppErrors.NetworkError())
    }
    catch (e: HttpException){
        val json= e.response()?.errorBody()?.string()
        val errorResponse = Gson().fromJson(json, CustomResponseError::class.java)
        return ApiResult.ErrorApiResult(error = AppErrors.ServerError(message = errorResponse.message!!))

    }
    catch (e:Throwable){
        return  ApiResult.ErrorApiResult(error = AppErrors.UnkoownError(message = e.localizedMessage?:"Soomething went wrong"))

    }
}