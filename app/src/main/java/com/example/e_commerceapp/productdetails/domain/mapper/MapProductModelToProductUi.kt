package com.example.e_commerceapp.productdetails.domain.mapper

import com.example.e_commerceapp.productlist.presentation.model.ProductUiModel
import com.example.e_commerceapp.productlist.domain.model.ProductDomainModel
import com.example.e_commerceapp.productlist.presentation.model.ProductType

object MapProductModelToProductUi {
    fun mapToUi(data: ProductDomainModel?): ProductUiModel {
        return ProductUiModel(
            id = data?.id,
            title = data?.title,
            price = data?.price,
            category = data?.category,
            description = data?.description,
            type = when (data?.type) {
                ProductType.BANNER.name -> ProductType.BANNER
                ProductType.SECTION.name -> ProductType.SECTION
                ProductType.PRODUCTLARGE.name -> ProductType.PRODUCTLARGE
                else -> ProductType.PRODUCT
            },
            image = data?.image
        )
    }
}

