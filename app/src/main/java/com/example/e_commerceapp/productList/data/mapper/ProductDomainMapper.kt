package com.example.e_commerceapp.productList.data.mapper

import com.example.e_commerceapp.productList.data.model.ProductDto
import com.example.e_commerceapp.productList.domain.model.ProductDomainModel

object ProductDomainMapper {
    fun mapToDomain(product: ProductDto?): ProductDomainModel {
        return ProductDomainModel(
            id = product?.id,
            title = product?.title,
            price = product?.price,
            category = product?.category,
            description = product?.description,
            image = product?.image
        )
    }
}