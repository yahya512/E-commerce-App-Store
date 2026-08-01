package com.example.e_commerceapp.productDetails.data.mapper

import com.example.e_commerceapp.productList.data.model.ProductDto
import com.example.e_commerceapp.productList.domain.model.ProductDomainModel

object MapProductToProductDomain {
    fun mapToDomain(data: ProductDto?): ProductDomainModel {
        return ProductDomainModel(
            id = data?.id,
            title = data?.title,
            price = data?.price,
            category = data?.category,
            description = data?.description,
            image = data?.image,
        )
    }
}