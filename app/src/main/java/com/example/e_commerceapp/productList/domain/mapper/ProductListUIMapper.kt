package com.example.e_commerceapp.productList.domain.mapper

import com.example.e_commerceapp.productList.domain.model.ProductDomainModel
import com.example.e_commerceapp.productList.presentation.model.ProductUiModel

object ProductListUIMapper {
    fun mapToDomainList(data: List<ProductDomainModel>?): List<ProductUiModel>? {
        return data?.let {
            data.map {
                ProductUiModelMapper.mapToUi(it)
            }
        }
    }
}