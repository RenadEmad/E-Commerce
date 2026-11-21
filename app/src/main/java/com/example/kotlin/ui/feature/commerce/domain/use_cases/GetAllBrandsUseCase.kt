package com.example.kotlin.ui.feature.commerce.domain.use_cases

import com.example.kotlin.ui.feature.commerce.domain.entities.common.CategoryItem
import com.example.kotlin.ui.feature.commerce.domain.repo.home.HomeRepo
import com.example.kotlin.ui.feature.network.utility.ApiResult
import javax.inject.Inject

class GetAllBrandsUseCase  @Inject constructor  (val homeRepo: HomeRepo) {

   suspend fun invoke() : ApiResult<List<CategoryItem>>{
        return homeRepo.getBrands()
    }

}