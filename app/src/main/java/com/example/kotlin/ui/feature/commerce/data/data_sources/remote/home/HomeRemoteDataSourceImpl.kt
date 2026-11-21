package com.example.kotlin.ui.feature.commerce.data.data_sources.remote.home

import com.example.kotlin.ui.core.Navigation.errors.AppErrors
import com.example.kotlin.ui.feature.network.api.ApiServices
import com.example.kotlin.ui.feature.network.models.response.category.CategoryResponseDto
import com.example.kotlin.ui.feature.network.models.response.response_error.CustomResponseError
import com.example.kotlin.ui.feature.network.utility.ApiResult
import com.example.kotlin.ui.feature.network.utility.SafeApiCall
import com.google.gson.Gson
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class HomeRemoteDataSourceImpl @Inject constructor (val apiServices:ApiServices) : HomeRemoteDataSource {
    override suspend fun getCategory(): ApiResult<CategoryResponseDto> =
        SafeApiCall {
            apiServices.getAllCategories()
        }






    override suspend fun getBrands(): ApiResult<CategoryResponseDto>
   = SafeApiCall {
        apiServices.getAllBrands()
    }


}