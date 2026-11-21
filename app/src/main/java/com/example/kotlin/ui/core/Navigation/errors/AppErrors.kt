package com.example.kotlin.ui.core.Navigation.errors

sealed class AppErrors(val errorMessage:String) {

data class NetworkError(val message:String="No internet connection.")
    : AppErrors(errorMessage = message)


    data class ServerError(val message:String="Server down.")
        : AppErrors(errorMessage = message)

    data class UnkoownError(val message:String="Something went wrong.")
        : AppErrors(errorMessage = message)
}