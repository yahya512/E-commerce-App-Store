package com.example.e_commerceapp.productlist.domain.mapper

import android.util.Log
import com.example.e_commerceapp.productlist.domain.model.ProductDomainModel
import com.example.e_commerceapp.productlist.presentation.adapter.BANNER
import com.example.e_commerceapp.productlist.presentation.adapter.PRODUCT
import com.example.e_commerceapp.productlist.presentation.adapter.SECTION
import com.example.e_commerceapp.productlist.presentation.model.ProductType
import com.example.e_commerceapp.productlist.presentation.model.ProductUiModel

object ProductUiModelMapper {
    fun mapToUi(product: ProductDomainModel?): ProductUiModel {


        val typeMapper = when (product?.type) {
            ProductType.BANNER.type -> ProductType.BANNER
            ProductType.SECTION.type -> ProductType.SECTION
            ProductType.PRODUCTLARGE.type -> ProductType.PRODUCTLARGE
            else -> ProductType.PRODUCT
        }



        return ProductUiModel(
            id = product?.id,
            title = product?.title,
            price = product?.price,
            category = product?.category,
            description = product?.description,
            type = typeMapper,
            image = product?.image
        )
    }
}
