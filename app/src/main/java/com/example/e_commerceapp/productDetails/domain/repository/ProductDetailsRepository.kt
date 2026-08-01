package com.example.e_commerceapp.productDetails.domain.repository

import com.example.e_commerceapp.productList.domain.model.ApiResultStatus
import com.example.e_commerceapp.productList.domain.model.ProductDomainModel

interface ProductDetailsRepository {

    suspend fun getProductById(id: Int): ApiResultStatus<ProductDomainModel?>
}