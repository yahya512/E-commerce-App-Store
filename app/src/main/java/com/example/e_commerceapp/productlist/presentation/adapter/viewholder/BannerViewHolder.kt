package com.example.e_commerceapp.productlist.presentation.adapter.viewholder

import android.graphics.drawable.Drawable
import androidx.core.R
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.e_commerceapp.databinding.BannerItemBinding
import com.example.e_commerceapp.productlist.presentation.adapter.OnClickItem
import com.example.e_commerceapp.productlist.presentation.model.ProductUiModel

class BannerViewHolder(val binding: BannerItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bannerBind(productsItem: ProductUiModel, productClickOn: OnClickItem) {
        binding.apply {
            bannerTextView.apply {
                text = productsItem.title
                setOnClickListener {
                    productClickOn.onClick(productsItem)
                }
            }
            Glide.with(itemView).load(productsItem.image)
                .placeholder(com.example.e_commerceapp.R.drawable.image_placeholder)
                .into(bannerImageView)

        }
    }
}