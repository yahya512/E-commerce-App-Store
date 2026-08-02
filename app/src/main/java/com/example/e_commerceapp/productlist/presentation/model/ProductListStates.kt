package com.example.e_commerceapp.productlist.presentation.model

sealed class ProductListStates {
    data class Success(val product: List<ProductUiModel>?) : ProductListStates()
    object Loading : ProductListStates()
    data class Error(val errorMessage: String) : ProductListStates()
}