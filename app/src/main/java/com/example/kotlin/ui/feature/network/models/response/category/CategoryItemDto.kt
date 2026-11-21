package com.example.kotlin.ui.feature.network.models.response.category


import com.google.gson.annotations.SerializedName

data class CategoryItemDto(
    @SerializedName("createdAt")
    val createdAt: String? = null,
    @SerializedName("_id")
    val id: String? = null,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("slug")
    val slug: String? = null,
    @SerializedName("category")
    val category: String? = null,
    @SerializedName("updatedAt")
    val updatedAt: String? = null
)