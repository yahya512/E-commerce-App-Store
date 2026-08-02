package com.example.e_commerceapp.productdetails.presentation.model

import com.example.e_commerceapp.productlist.presentation.model.ProductUiModel

sealed class ProductsDetailsStates {
    data class Success(val product: ProductUiModel) : ProductsDetailsStates()
    object Loading : ProductsDetailsStates()
    data class Error(val errorMessage: String) : ProductsDetailsStates()

}