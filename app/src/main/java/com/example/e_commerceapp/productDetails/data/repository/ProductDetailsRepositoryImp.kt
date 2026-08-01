package com.example.e_commerceapp.productDetails.data.repository

import com.example.e_commerceapp.productDetails.data.mapper.MapProductToProductDomain
import com.example.e_commerceapp.productDetails.data.remote.ProductDetailsApi
import com.example.e_commerceapp.productDetails.domain.repository.ProductDetailsRepository
import com.example.e_commerceapp.productList.data.remote.safeApiCall
import com.example.e_commerceapp.productList.domain.model.ApiResultStatus
import com.example.e_commerceapp.productList.domain.model.ProductDomainModel
import jakarta.inject.Inject

class ProductDetailsRepositoryImp @Inject constructor(private val apiServices: ProductDetailsApi) :
    ProductDetailsRepository {
    override suspend fun getProductById(id: Int): ApiResultStatus<ProductDomainModel?> {
        val productResponse = safeApiCall { apiServices.getProductById(id) }
        when (productResponse) {
            is ApiResultStatus.Success -> {
                val productDomainModel =
                    MapProductToProductDomain.mapToDomain(productResponse.data.product)
                return ApiResultStatus.Success(productDomainModel)
            }

            is ApiResultStatus.Error -> {
                return ApiResultStatus.Error(productResponse.errorMessage)
            }
        }
    }
}