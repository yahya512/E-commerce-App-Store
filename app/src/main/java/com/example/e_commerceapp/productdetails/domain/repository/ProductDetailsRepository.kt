package com.example.e_commerceapp.productdetails.domain.repository

import com.example.e_commerceapp.productlist.domain.model.ApiResultStatus
import com.example.e_commerceapp.productlist.domain.model.ProductDomainModel

interface ProductDetailsRepository {

    suspend fun getProductById(id: Int): ApiResultStatus<ProductDomainModel?>
}