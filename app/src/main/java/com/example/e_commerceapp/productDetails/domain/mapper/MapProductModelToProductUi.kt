package com.example.e_commerceapp.productDetails.domain.mapper

import com.example.e_commerceapp.productList.presentation.model.ProductUiModel
import com.example.e_commerceapp.productList.domain.model.ProductDomainModel

object MapProductModelToProductUi {
    fun mapToUi(data: ProductDomainModel?): ProductUiModel {
        return ProductUiModel(
            id = data?.id,
            title = data?.title,
            price = data?.price,
            category = data?.category,
            description = data?.description,
            image = data?.image
        )
    }
}

