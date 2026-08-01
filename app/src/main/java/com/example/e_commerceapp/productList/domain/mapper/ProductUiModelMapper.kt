package com.example.e_commerceapp.productList.domain.mapper

import com.example.e_commerceapp.productList.domain.model.ProductDomainModel
import com.example.e_commerceapp.productList.presentation.model.ProductUiModel

object ProductUiModelMapper {
    fun mapToUi(product: ProductDomainModel?): ProductUiModel {
        return ProductUiModel(
            id = product?.id,
            title = product?.title,
            price = product?.price,
            category = product?.category,
            description = product?.description,
            image = product?.image
        )
    }
}
