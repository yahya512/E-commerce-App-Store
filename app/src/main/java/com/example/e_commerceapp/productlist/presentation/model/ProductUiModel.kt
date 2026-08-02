package com.example.e_commerceapp.productlist.presentation.model

data class ProductUiModel(
    val id: Int?,
    val title: String?,
    val price: Double?,
    val category: String?,
    val description: String?,
    val type: ProductType?,
    val image: String?
)