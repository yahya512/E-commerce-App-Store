package com.example.e_commerceapp.productlist.domain.repository

import com.example.e_commerceapp.productlist.domain.model.ApiResultStatus
import com.example.e_commerceapp.productlist.domain.model.ProductDomainModel

interface ProductListRepository {
    suspend fun getAllProducts(): ApiResultStatus<List<ProductDomainModel>?>

}