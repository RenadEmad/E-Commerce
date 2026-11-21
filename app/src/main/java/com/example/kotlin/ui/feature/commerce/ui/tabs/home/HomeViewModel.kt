package com.example.kotlin.ui.feature.commerce.ui.tabs.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.ui.core.Navigation.errors.AppErrors
import com.example.kotlin.ui.feature.commerce.domain.entities.common.CategoryItem
import com.example.kotlin.ui.feature.commerce.domain.use_cases.GetAllBrandsUseCase
import com.example.kotlin.ui.feature.commerce.domain.use_cases.GetAllCategoryUseCase
import com.example.kotlin.ui.feature.commerce.domain.utility.Resource
import com.example.kotlin.ui.feature.network.utility.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class HomeViewModel @Inject constructor (
     val getAllCategoryUseCase: GetAllCategoryUseCase,
     val getAllBrandsUseCase: GetAllBrandsUseCase
) : ViewModel() {

    private val _states = MutableStateFlow(HomeStates())
    val state: StateFlow<HomeStates> = _states.asStateFlow()


    init {
        loadCategory()
        loadBrands()
    }

    fun loadCategory() {

        viewModelScope.launch {

            _states.value= _states.value.copy(categoryState = Resource.Loading)
            when(val result =getAllCategoryUseCase.invoke())
            {
                is ApiResult.ErrorApiResult ->
                    _states.value.copy(
                        categoryState = Resource.Error(errorMessage = result.error.errorMessage)

                )
//                is ApiResult.SuccessApiResult <List<CategoryItem>> ->
//_states.value=_states.value.copy(
//    categoryState =Resource.Success(data = result.data!!)
//
//)
                is ApiResult.SuccessApiResult -> _states.update {
                    it.copy(categoryState = Resource.Success(data = result.data!!))
                }
            }

        }




    }

    fun loadBrands() {


        viewModelScope.launch {
            _states.value=_states.value.copy(
                brandState = Resource.Loading
            )
            when(val result=getAllBrandsUseCase.invoke()){
                is ApiResult.ErrorApiResult ->
                    _states.value=_states.value.copy(
                        brandState = Resource.Error(errorMessage = result.error.errorMessage)
                    )
                is ApiResult.SuccessApiResult<List<CategoryItem>> ->
                    _states.value=_states.value.copy(
                        brandState = Resource.Success(data = result.data!!)
                    )
            }
        }




    }
}