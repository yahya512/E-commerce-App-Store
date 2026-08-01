package com.example.e_commerceapp.productDetails.data.remote

import com.example.e_commerceapp.productDetails.data.model.ProductDetailsModel
import com.example.e_commerceapp.productList.data.model.ApiService
import com.example.e_commerceapp.productList.data.model.ProductDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductDetailsApi {
    @GET("test/products/{id}")
    suspend fun getProductById(@Path("id") productId: Int): ApiService<ProductDetailsModel>

}