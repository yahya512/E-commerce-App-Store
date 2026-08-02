package com.example.e_commerceapp.productdetails.data.remote

import com.example.e_commerceapp.productdetails.data.model.ProductDetailsResponse
import com.example.e_commerceapp.productlist.data.model.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductDetailsApi {
    @GET("test/products/{id}")
    suspend fun getProductById(@Path("id") productId: Int): BaseResponse<ProductDetailsResponse>

}