package com.example.e_commerceapp.productlist.presentation.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.e_commerceapp.R
import com.example.e_commerceapp.databinding.ProductItemBinding
import com.example.e_commerceapp.productlist.presentation.adapter.OnClickItem
import com.example.e_commerceapp.productlist.presentation.model.ProductUiModel

class ProductViewHolder(val binding: ProductItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(productsItem: ProductUiModel, productClickOn: OnClickItem) {

        binding.apply {
            productNameTv.text = productsItem.title
            productPriceTv.text =
                itemView.context.getString(R.string.price, productsItem.price.toString())
            productCategoryTv.text = productsItem.category
            Glide
                .with(itemView)
                .load(productsItem.image)
                .placeholder(R.drawable.image_placeholder)
                .into(imageViewId)
            cardView.setOnClickListener {
                productClickOn.onClick(productsItem)
            }
        }

    }

}