package com.example.kotlin.ui.feature.commerce.data.data_sources.mappers

import com.example.kotlin.ui.feature.commerce.domain.entities.common.CategoryItem
import com.example.kotlin.ui.feature.network.models.response.category.CategoryItemDto

fun CategoryItemDto.toCategory() : CategoryItem{
    return  CategoryItem(
        image = this.image
        ,name=this.name,
        id=this.id,
        category =this.category
    )
}