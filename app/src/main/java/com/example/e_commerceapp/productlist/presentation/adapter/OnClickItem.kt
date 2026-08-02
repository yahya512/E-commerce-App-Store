package com.example.e_commerceapp.productlist.presentation.adapter

import com.example.e_commerceapp.productlist.presentation.model.ProductUiModel

interface OnClickItem {
    fun onClick(item: ProductUiModel)
}