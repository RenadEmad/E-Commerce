package com.example.kotlin.ui.feature.network.models.response.category


import com.example.kotlin.ui.feature.network.models.response.common.MetadataDto
import com.google.gson.annotations.SerializedName

data class CategoryResponseDto(
    @SerializedName("data")
    val `data`: List<CategoryItemDto?>? = null,
    @SerializedName("metadata")
    val metadata: MetadataDto? = null,
    @SerializedName("results")
    val results: Int? = null
)