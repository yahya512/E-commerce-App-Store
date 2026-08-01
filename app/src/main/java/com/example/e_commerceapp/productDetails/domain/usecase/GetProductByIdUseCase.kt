package com.example.e_commerceapp.productDetails.domain.usecase

import com.example.e_commerceapp.productDetails.domain.repository.ProductDetailsRepository
import com.example.e_commerceapp.productList.domain.model.ApiResultStatus
import com.example.e_commerceapp.productList.domain.model.ProductDomainModel
import javax.inject.Inject

class GetProductByIdUseCase @Inject constructor(private val repository: ProductDetailsRepository) {
    suspend operator fun invoke(id: Int): ApiResultStatus<ProductDomainModel?> {
        return repository.getProductById(id)
    }
}