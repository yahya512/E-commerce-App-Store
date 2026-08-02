package com.example.e_commerceapp.productlist.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.e_commerceapp.productlist.presentation.model.ProductUiModel

class ProductDiffUtil : DiffUtil.ItemCallback<ProductUiModel>() {
    override fun areItemsTheSame(
        oldItem: ProductUiModel,
        newItem: ProductUiModel
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: ProductUiModel,
        newItem: ProductUiModel
    ): Boolean {
        return oldItem == newItem
    }
}