package com.example.kotlin.ui.feature.network.models.response.common


import com.google.gson.annotations.SerializedName

data class MetadataDto(
    @SerializedName("currentPage")
    val currentPage: Int? = null,
    @SerializedName("limit")
    val limit: Int? = null,
    @SerializedName("numberOfPages")
    val numberOfPages: Int? = null
)