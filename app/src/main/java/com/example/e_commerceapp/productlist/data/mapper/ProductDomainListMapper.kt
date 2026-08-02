package com.example.e_commerceapp.productlist.data.mapper

import com.example.e_commerceapp.productlist.data.model.ProductDto
import com.example.e_commerceapp.productlist.domain.model.ProductDomainModel

object ProductDomainListMapper {
    fun mapToDomainList(data: List<ProductDto>?): List<ProductDomainModel>? {
        return data?.let {
            data.map {
                ProductDomainMapper.mapToDomain(it)
            }
        }
    }
}
