package com.example.e_commerceapp.productlist.domain.usecase

import com.example.e_commerceapp.productlist.domain.model.ApiResultStatus
import com.example.e_commerceapp.productlist.domain.model.ProductDomainModel
import com.example.e_commerceapp.productlist.domain.repository.ProductListRepository
import javax.inject.Inject


class GetAllProductUseCase @Inject constructor(private val repository: ProductListRepository) {
    suspend operator fun invoke(): ApiResultStatus<List<ProductDomainModel>?> {
        return repository.getAllProducts()
    }
}