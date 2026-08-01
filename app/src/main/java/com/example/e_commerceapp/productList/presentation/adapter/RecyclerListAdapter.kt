package com.example.e_commerceapp.productList.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.e_commerceapp.R
import com.example.e_commerceapp.databinding.ProductItemBinding
import com.example.e_commerceapp.productList.presentation.model.ProductUiModel
import com.example.e_commerceapp.productList.presentation.ui.ProductsListFragment

class RecyclerListAdapter(
    private var onClickItem: (ProductUiModel) -> Unit

) : ListAdapter<ProductUiModel, RecyclerListAdapter.ProductViewHolder>(ProductDiffUtil()) {
    class ProductViewHolder(val binding: ProductItemBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductViewHolder {
        val view = ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ProductViewHolder,
        position: Int
    ) {
        val productsItem = getItem(position) // or currentList[position]
        holder.binding.apply {
            productNameTv.text = productsItem.title
            productPriceTv.text =
                holder.itemView.context.getString(R.string.price, productsItem.price.toString())
            productCategoryTv.text = productsItem.category
            Glide
                .with(holder.itemView)
                .load(productsItem.image)
                .placeholder(R.drawable.image_placeholder)
                .into(imageViewId)
            cardView.setOnClickListener {
                onClickItem(productsItem)
            }
        }
    }
}