package com.example.e_commerceapp.productList.data.remote

import com.example.e_commerceapp.productList.data.model.AllProductsResponse
import com.example.e_commerceapp.productList.data.model.ApiService
import com.example.e_commerceapp.productList.data.model.ProductDto
import retrofit2.http.GET

//https://skyblue-dogfish-178203.hostingersite.com/api/
interface ProductListApi {
    @GET("test/products")
    suspend fun getAllProducts(): ApiService<AllProductsResponse>
}