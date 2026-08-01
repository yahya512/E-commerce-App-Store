package com.example.e_commerceapp.productList.data.repository

import com.example.e_commerceapp.productList.data.mapper.ProductDomainListMapper
import com.example.e_commerceapp.productList.data.remote.ProductListApi
import com.example.e_commerceapp.productList.data.remote.safeApiCall
import com.example.e_commerceapp.productList.domain.model.ApiResultStatus
import com.example.e_commerceapp.productList.domain.model.ProductDomainModel
import com.example.e_commerceapp.productList.domain.repository.ProductListRepository
import jakarta.inject.Inject

class ProductListRepositoryImp @Inject constructor(private val apiService: ProductListApi) :
    ProductListRepository {
    override suspend fun getAllProducts(): ApiResultStatus<List<ProductDomainModel>?> {
        val productResponse = safeApiCall { apiService.getAllProducts() }

        when (productResponse) {
            is ApiResultStatus.Success -> {
                val productDomainModelList =
                    ProductDomainListMapper.mapToDomainList(productResponse.data.products)
                return ApiResultStatus.Success(productDomainModelList)
            }

            is ApiResultStatus.Error -> {
                return ApiResultStatus.Error(productResponse.errorMessage)
            }
        }
    }
}

// object dto to domain
// mapper from dto to domain in data layer
// mapper from domain to ui model in domain layer