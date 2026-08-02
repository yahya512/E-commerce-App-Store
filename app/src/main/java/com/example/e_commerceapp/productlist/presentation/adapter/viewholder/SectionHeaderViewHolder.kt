package com.example.e_commerceapp.productlist.presentation.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerceapp.databinding.SectionHeaderBinding
import com.example.e_commerceapp.productlist.presentation.adapter.OnClickItem
import com.example.e_commerceapp.productlist.presentation.model.ProductUiModel

class SectionHeaderViewHolder(val binding: SectionHeaderBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun sectionBind(productsItem: ProductUiModel, productClickOn: OnClickItem) {
        binding.apply {
            sectionTextView.apply {
                text = productsItem.title
                setOnClickListener {
                    productClickOn.onClick(productsItem)
                }
            }

        }

    }
}