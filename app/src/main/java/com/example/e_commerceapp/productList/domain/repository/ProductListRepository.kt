package com.example.e_commerceapp.productList.domain.repository

import com.example.e_commerceapp.productList.domain.model.ApiResultStatus
import com.example.e_commerceapp.productList.domain.model.ProductDomainModel

interface ProductListRepository {
    suspend fun getAllProducts(): ApiResultStatus<List<ProductDomainModel>?>

}