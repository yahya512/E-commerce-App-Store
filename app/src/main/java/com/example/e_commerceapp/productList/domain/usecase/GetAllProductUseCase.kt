package com.example.e_commerceapp.productList.domain.usecase

import com.example.e_commerceapp.productList.domain.model.ApiResultStatus
import com.example.e_commerceapp.productList.domain.model.ProductDomainModel
import com.example.e_commerceapp.productList.domain.repository.ProductListRepository
import javax.inject.Inject


class GetAllProductUseCase @Inject constructor(private val repository: ProductListRepository) {
    suspend operator fun invoke(): ApiResultStatus<List<ProductDomainModel>?> {
        return repository.getAllProducts()
    }
}