package com.example.e_commerceapp.productDetails.presentation.model

import com.example.e_commerceapp.productList.presentation.model.ProductUiModel

sealed class ProductsDetailsStates {
    data class Success(val product: ProductUiModel) : ProductsDetailsStates()
    object Loading : ProductsDetailsStates()
    data class Error(val errorMessage: String) : ProductsDetailsStates()

}