package com.example.e_commerceapp.productlist.data.remote

import com.example.e_commerceapp.productlist.data.model.AllProductsResponse
import com.example.e_commerceapp.productlist.data.model.BaseResponse
import retrofit2.http.GET

//https://skyblue-dogfish-178203.hostingersite.com/api/
interface ProductListApi {
    @GET("test/products?layout=mixed")
    suspend fun getAllProducts(): BaseResponse<AllProductsResponse>
}