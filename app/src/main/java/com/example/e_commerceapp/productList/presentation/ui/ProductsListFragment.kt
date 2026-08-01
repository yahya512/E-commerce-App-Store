package com.example.e_commerceapp.productList.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.e_commerceapp.databinding.FragmentProductsListBinding
import com.example.e_commerceapp.productList.presentation.adapter.RecyclerListAdapter
import com.example.e_commerceapp.productList.presentation.model.ProductListStates
import com.example.e_commerceapp.productList.presentation.model.ProductUiModel
import com.example.e_commerceapp.productList.presentation.viewModel.ProductListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProductsListFragment : Fragment() {

    private lateinit var binding: FragmentProductsListBinding
//    private late init var viewModel: SharedViewModel

    private val viewModel: ProductListViewModel by viewModels()

    //    private late init var searchText: SearchProductUseCase
    private lateinit var adapter: RecyclerListAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductsListBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
//        viewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
//        searchText = viewModel.searchProductListViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // launch the all products
        viewModel.getAllProduct()

        // swip to refresh
        binding.swipToRefresh.setOnRefreshListener {
            viewModel.getAllProduct()
        }
//         search in products
//        binding.apply {
//            searchText.addTextChangedListener() {
//                val query = it.toString()
//                viewLifecycleOwner.lifecycleScope.launch {
//                    if (::adapter.isInitialized) {
//                        // when we use RecyclerAdapter ->  adapter.updateList(searchText(query))
//                        adapter.submitList(searchText(query))
//                    }
//                }
//            }
//        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.stateFlowList.collect {
                    Log.d("list", "$it")
                    when (it) {
                        is ProductListStates.Error -> {
                            binding.apply {
//                                searchText.isVisible = false
                                netWorkErrorTv.text = it.errorMessage
                                netWorkErrorTv.isVisible = true
                                progressBarProductList.isVisible = false
                                swipToRefresh.isRefreshing = false
                            }
                        }

                        ProductListStates.Loading -> {
                            Toast.makeText(
                                requireContext(), "Loading Data Please Wait...", Toast.LENGTH_SHORT
                            ).show()
                            binding.apply {
//                                searchText.isVisible = false
                                progressBarProductList.isVisible = true
                                netWorkErrorTv.isVisible = false
                                recyclerViewId.isVisible = false
                                swipToRefresh.isRefreshing = false
                            }
                        }

                        is ProductListStates.Success -> {

                            binding.apply {
//                                searchText.isVisible = false
//                                searchText.text = null
                                progressBarProductList.isVisible = false
                                netWorkErrorTv.isVisible = false
                                recyclerViewId.isVisible = true
                                swipToRefresh.isRefreshing = false

                            }
                            showProducts(it.product ?: emptyList())
                        }
                    }

                }
            }
        }
    }

    private fun showProducts(productList: List<ProductUiModel>) {
        adapter = RecyclerListAdapter { product ->
            product.id?.let {
                val action =
                    ProductsListFragmentDirections.actionProductsList2ToProductDetails(
                        product.id
                    )
                findNavController().navigate(action)
            }
        }
        binding.recyclerViewId.adapter = adapter
        adapter.submitList(productList)
    }
}