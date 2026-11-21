package com.example.kotlin.ui.feature.network.models.response.product


import com.example.kotlin.ui.feature.network.models.response.category.CategoryItemDto
import com.google.gson.annotations.SerializedName

data class ProductItemDto(
    @SerializedName("availableColors")
    val availableColors: List<Any?>? = null,
    @SerializedName("brand")
    val brand: CategoryItemDto? = null,
    @SerializedName("category")
    val category: CategoryItemDto? = null,
    @SerializedName("createdAt")
    val createdAt: String? = null,
    @SerializedName("description")
    val description: String? = null,

    @SerializedName("id")
    val id: String? = null,
    @SerializedName("imageCover")
    val imageCover: String? = null,
    @SerializedName("images")
    val images: List<String?>? = null,
    @SerializedName("price")
    val price: Int? = null,
    @SerializedName("priceAfterDiscount")
    val priceAfterDiscount: Int? = null,
    @SerializedName("quantity")
    val quantity: Int? = null,
    @SerializedName("ratingsAverage")
    val ratingsAverage: Double? = null,
    @SerializedName("ratingsQuantity")
    val ratingsQuantity: Int? = null,
    @SerializedName("slug")
    val slug: String? = null,
    @SerializedName("sold")
    val sold: Int? = null,
    @SerializedName("subcategory")
    val subcategory: List<CategoryItemDto?>? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("updatedAt")
    val updatedAt: String? = null
)