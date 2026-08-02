package com.example.e_commerceapp.productdetails.data.mapper

import com.example.e_commerceapp.productlist.data.model.ProductDto
import com.example.e_commerceapp.productlist.domain.model.ProductDomainModel

object MapProductToProductDomain {
    fun mapToDomain(data: ProductDto?): ProductDomainModel {
        return ProductDomainModel(
            id = data?.id,
            title = data?.title,
            price = data?.price,
            category = data?.category,
            description = data?.description,
            type = data?.type,
            image = data?.image,
        )
    }
}