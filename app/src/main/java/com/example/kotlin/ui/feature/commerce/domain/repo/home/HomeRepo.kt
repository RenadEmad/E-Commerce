package com.example.kotlin.ui.feature.commerce.domain.repo.home

import com.example.kotlin.ui.feature.commerce.domain.entities.common.CategoryItem
import com.example.kotlin.ui.feature.network.utility.ApiResult

interface HomeRepo {

   suspend fun getCategory() : ApiResult<List<CategoryItem>>
    suspend fun getBrands() : ApiResult<List<CategoryItem>>

}