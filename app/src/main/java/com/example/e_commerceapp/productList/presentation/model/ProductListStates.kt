package com.example.e_commerceapp.productList.presentation.model

sealed class ProductListStates {
    data class Success(val product: List<ProductUiModel>?) : ProductListStates()
    object Loading : ProductListStates()
    data class Error(val errorMessage: String) : ProductListStates()
}