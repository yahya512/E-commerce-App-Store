package com.example.e_commerceapp.productdetails.domain.usecase

import com.example.e_commerceapp.productdetails.domain.repository.ProductDetailsRepository
import com.example.e_commerceapp.productlist.domain.model.ApiResultStatus
import com.example.e_commerceapp.productlist.domain.model.ProductDomainModel
import javax.inject.Inject

class GetProductByIdUseCase @Inject constructor(private val repository: ProductDetailsRepository) {
    suspend operator fun invoke(id: Int): ApiResultStatus<ProductDomainModel?> {
        return repository.getProductById(id)
    }
}