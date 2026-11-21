package com.example.kotlin.ui.feature.commerce.data.data_sources.remote.home

import com.example.kotlin.ui.feature.network.models.response.category.CategoryResponseDto
import com.example.kotlin.ui.feature.network.utility.ApiResult

interface HomeRemoteDataSource {
    suspend fun getCategory(): ApiResult<CategoryResponseDto>

    suspend fun getBrands():ApiResult<CategoryResponseDto>


}