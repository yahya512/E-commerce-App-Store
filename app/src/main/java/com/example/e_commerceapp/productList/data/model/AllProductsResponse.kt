package com.example.e_commerceapp.productList.data.model

// response return from server "products" : [{...}]
data class AllProductsResponse(
    val products: List<ProductDto>?
)
