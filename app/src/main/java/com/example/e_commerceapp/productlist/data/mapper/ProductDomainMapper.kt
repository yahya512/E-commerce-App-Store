package com.example.e_commerceapp.productlist.data.mapper

import com.example.e_commerceapp.productlist.data.model.ProductDto
import com.example.e_commerceapp.productlist.domain.model.ProductDomainModel

object ProductDomainMapper {
    fun mapToDomain(product: ProductDto?): ProductDomainModel {
        return ProductDomainModel(
            id = product?.id,
            title = product?.title,
            price = product?.price,
            category = product?.category,
            description = product?.description,
            type = product?.type,
            image = product?.image
        )
    }
}