package com.example.e_commerceapp.productList.data.model

import com.google.gson.annotations.SerializedName

data class ApiService<T>(
    @SerializedName("status") val status: Boolean?,
    @SerializedName("message") val message: String?,
    @SerializedName("data") val data: T?
)


