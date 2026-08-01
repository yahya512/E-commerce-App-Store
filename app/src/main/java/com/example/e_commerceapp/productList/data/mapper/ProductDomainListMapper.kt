package com.example.e_commerceapp.productList.data.mapper

import com.example.e_commerceapp.productDetails.data.mapper.MapProductToProductDomain
import com.example.e_commerceapp.productList.data.model.ProductDto
import com.example.e_commerceapp.productList.domain.model.ProductDomainModel

object ProductDomainListMapper {
    fun mapToDomainList(data: List<ProductDto>?): List<ProductDomainModel>? {
        return data?.let {
            data.map {
                ProductDomainMapper.mapToDomain(it)
            }
        }
    }
}
