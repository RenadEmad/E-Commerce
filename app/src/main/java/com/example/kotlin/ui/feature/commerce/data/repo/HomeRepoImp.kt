package com.example.kotlin.ui.feature.commerce.data.repo

import com.example.kotlin.ui.core.Navigation.errors.AppErrors
import com.example.kotlin.ui.feature.commerce.data.data_sources.mappers.toCategory
import com.example.kotlin.ui.feature.commerce.data.data_sources.remote.home.HomeRemoteDataSource
import com.example.kotlin.ui.feature.commerce.domain.entities.common.CategoryItem
import com.example.kotlin.ui.feature.commerce.domain.repo.home.HomeRepo
import com.example.kotlin.ui.feature.network.models.response.category.CategoryResponseDto
import com.example.kotlin.ui.feature.network.utility.ApiResult
import javax.inject.Inject

class HomeRepoImp  @Inject constructor (val homeRemoteDataSource: HomeRemoteDataSource):HomeRepo {
    override suspend fun getCategory(): ApiResult<List<CategoryItem>> {

       return when(val result=homeRemoteDataSource.getCategory())
        {
            is ApiResult.ErrorApiResult -> {
                ApiResult.ErrorApiResult(error = AppErrors.ServerError(message = result.error.errorMessage))
            }
            is ApiResult.SuccessApiResult <CategoryResponseDto>-> {
                ApiResult.SuccessApiResult(
                    data=result.data?.data?.map {
                        categoryItemDto ->
                       return@map categoryItemDto?.toCategory()
                    }?.filterNotNull()?: emptyList()
                )
            }
        }

    }




    override suspend fun getBrands(): ApiResult<List<CategoryItem>> {


        return when(val result=homeRemoteDataSource.getBrands())
        {
            is ApiResult.ErrorApiResult -> {
                ApiResult.ErrorApiResult(error = AppErrors.ServerError(message = result.error.errorMessage))
            }
            is ApiResult.SuccessApiResult <CategoryResponseDto>-> {
                ApiResult.SuccessApiResult(
                    data=result.data?.data?.map {
                            categoryItemDto ->
                        return@map categoryItemDto?.toCategory()
                    }?.filterNotNull()?: emptyList()
                )
            }
        }
    }
}