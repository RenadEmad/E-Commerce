package com.example.kotlin.ui.feature.commerce.ui.tabs.home

import com.example.kotlin.ui.feature.commerce.domain.entities.common.CategoryItem
import com.example.kotlin.ui.feature.commerce.domain.utility.Resource

data class HomeStates
    (
val categoryState: Resource<List<CategoryItem>> = Resource.Initial,
val brandState: Resource<List<CategoryItem>> = Resource.Initial

            )
