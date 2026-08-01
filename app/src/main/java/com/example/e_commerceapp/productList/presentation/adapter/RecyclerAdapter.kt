package com.example.e_commerceapp.productList.presentation.adapter//package com.example.e_commerceapp.presentation.adapters
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.e_commerceapp.productList.data.model.Product
//import com.example.e_commerceapp.databinding.ProductItemBinding
//
//
//// listAdapter - DiffUtil
//class RecyclerAdapter(
//    private var productsList: List<Product>,
//    private val onClickItem: (Product) -> Unit
//) :
//    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
//
//
//    class ViewHolder(val binding: ProductItemBinding) : RecyclerView.ViewHolder(binding.root)
//
//    override fun onCreateViewHolder(
//        parent: ViewGroup,
//        viewType: Int
//    ): ViewHolder {
//        val view = ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(
//        holder: ViewHolder,
//        position: Int
//    ) {
//        holder.binding.apply {
//            productNameTv.text = productsList[position].name
//            productPriceTv.text = "Price: ${productsList[position].price}"
//            productCategoryTv.text = productsList[position].category
//            productDescriptionTv.text = productsList[position].description
//            isInStoke.text =
//                if (productsList[position].inStock) "Available in Stock" else "Not Available in Stock"
//            //When I click on Item
//            cardView.setOnClickListener {
//                onClickItem(productsList[position])
//            }
//
//        }
//    }
//
//    override fun getItemCount() = productsList.size
//
//    fun updateList(newList: List<Product>) {
//        productsList = newList
//        notifyDataSetChanged()
//    }
//}