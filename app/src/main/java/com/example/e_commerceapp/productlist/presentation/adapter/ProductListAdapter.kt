package com.example.e_commerceapp.productlist.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerceapp.databinding.BannerItemBinding
import com.example.e_commerceapp.databinding.ProductItemBinding
import com.example.e_commerceapp.databinding.SectionHeaderBinding
import com.example.e_commerceapp.productlist.presentation.adapter.viewholder.BannerViewHolder
import com.example.e_commerceapp.productlist.presentation.adapter.viewholder.ProductViewHolder
import com.example.e_commerceapp.productlist.presentation.adapter.viewholder.SectionHeaderViewHolder
import com.example.e_commerceapp.productlist.presentation.model.ProductType
import com.example.e_commerceapp.productlist.presentation.model.ProductUiModel

const val PRODUCT = 0
const val BANNER = 1
const val SECTION = 2

class ProductListAdapter(
    private val listener: OnClickItem
) : ListAdapter<ProductUiModel, RecyclerView.ViewHolder>(ProductDiffUtil()) {


    override fun getItemViewType(position: Int): Int {

        Log.d("type", "${getItem(position).type}")

        return when (getItem(position).type) {
            ProductType.SECTION -> {
                SECTION
            }

            ProductType.BANNER -> {
                BANNER
            }

            else -> {
                PRODUCT
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): RecyclerView.ViewHolder {

        Log.d("viewType", "$viewType")
        return when (viewType) {
            SECTION -> {
                val view =
                    SectionHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                SectionHeaderViewHolder(view)
            }

            BANNER -> {
                val view =
                    BannerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                BannerViewHolder(view)
            }

            else -> {
                val view =
                    ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ProductViewHolder(view)
            }
        }
    }


    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder, position: Int
    ) {
        val productItem = getItem(position)
        when (holder) {
            is SectionHeaderViewHolder -> {
                holder.sectionBind(productItem, listener)
            }

            is BannerViewHolder -> {
                holder.bannerBind(productItem, listener)
            }

            is ProductViewHolder -> {
                holder.bind(productItem, listener)
            }
        }
    }
}




