package com.example.kotlin.ui.feature.network.models.response.product


import com.example.kotlin.ui.feature.network.models.response.common.MetadataDto
import com.google.gson.annotations.SerializedName

data class ProductResponseDto(
    @SerializedName("data")
    val `data`: List<ProductItemDto?>? = null,
    @SerializedName("metadata")
    val metadata: MetadataDto? = null,
    @SerializedName("results")
    val results: Int? = null
)