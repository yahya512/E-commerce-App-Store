package com.example.e_commerceapp.productlist.domain.mapper

import com.example.e_commerceapp.productlist.domain.model.ProductDomainModel
import com.example.e_commerceapp.productlist.presentation.model.ProductUiModel

object ProductListUIMapper {
    fun mapToDomainList(data: List<ProductDomainModel>?): List<ProductUiModel>? {
        return data?.let {
            data.map {
                ProductUiModelMapper.mapToUi(it)
            }
        }
    }
}