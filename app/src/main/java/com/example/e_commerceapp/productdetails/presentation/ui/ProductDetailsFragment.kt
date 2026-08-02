package com.example.e_commerceapp.productdetails.presentation.ui

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
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.e_commerceapp.R
import com.example.e_commerceapp.databinding.FragmentProductDetailsBinding
import com.example.e_commerceapp.productdetails.presentation.model.ProductsDetailsStates
import com.example.e_commerceapp.productdetails.presentation.viewModel.ProductDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlin.getValue

@AndroidEntryPoint
class ProductDetailsFragment : Fragment() {
    private lateinit var binding: FragmentProductDetailsBinding
    val args: ProductDetailsFragmentArgs by navArgs()

    //    private late init var viewModel: SharedViewModel
    val viewModel: ProductDetailsViewModel by viewModels() // after apply Injection
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentProductDetailsBinding.inflate(inflater, container, false)
//        viewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        viewModel.getProductByID(args.id)

        viewModel.getProductById(sendId())
        showProductDetails()
        binding.swipToRefresh.setOnRefreshListener {
            viewModel.getProductById(sendId())
//
        }
    }

    fun sendId(): Int {
        val productId = args.id
        return productId
    }

    // Using StateFlow
    private fun showProductDetails() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.stateFlowDetails.collect {
                    when (it) {
                        is ProductsDetailsStates.Error -> {
                            binding.apply {
                                errorTextForProductDetails.text = it.errorMessage
                                errorTextForProductDetails.isVisible = true
                                progressBar.isVisible = false
                                swipToRefresh.isRefreshing = false
                            }
                        }

                        ProductsDetailsStates.Loading -> {
                            binding.apply {
                                progressBar.isVisible = true
                                errorTextForProductDetails.isVisible = false
                                swipToRefresh.isRefreshing = false
                            }

                            Toast.makeText(
                                requireContext(), "Loading Data Please Wait...", Toast.LENGTH_SHORT
                            ).show()
                        }

                        is ProductsDetailsStates.Success -> {
                            binding.apply {
                                progressBar.isVisible = false
                                swipToRefresh.isVisible = false
                                imageView.isVisible = true
                                productName.isVisible = true
                                productPrice.isVisible = true
                                productCategory.isVisible = true
                                productDescription.isVisible = true

                                productName.text = getString(R.string.name, it.product.title)
                                productPrice.text =
                                    getString(R.string.price, it.product.price.toString())
                                productCategory.text =
                                    getString(R.string.category, it.product.category)
                                productDescription.text =
                                    getString(R.string.description, it.product.description)

//                                Log.d("image", it.product.image)
                                Glide
                                    .with(requireContext())
                                    .load(it.product.image)
                                    .placeholder(R.drawable.image_placeholder)
                                    .into(imageView)
                            }
                        }
                    }
                    Log.d("flow1", "$it")
                }
            }
        }
    }
}


// Using Live Data
/*
viewModel.states.observe(viewLifecycleOwner) { state ->
            binding.apply {
                when (state) {
                    ProductsDetailsStates.Loading -> {
                        progressBar.isVisible = true
                        Toast.makeText(
                            requireContext(), "Loading Data Please Wait...", Toast.LENGTH_SHORT
                        ).show()
                    }

                    is ProductsDetailsStates.Success -> {
                        progressBar.isVisible = false
                        productName.text = "name : ${state.product?.name}"
                        productPrice.text = "price: ${state.product?.price}\$"
                        productCategory.text = "Category: ${state.product?.category}"
                        productDescription.text = "Description: ${state.product?.description}"
                        isInStoke.text =
                            if (state.product!!.inStock) "Available in Stoke" else "Not Available in Stoke"
                    }

                    is ProductsDetailsStates.Error -> {}
                    else -> {}
                }
                Log.d("trace", "$state")

            }
        }

       clear the old value in the stream
       override fun onDestroyView() {
        super.onDestroyView()
        viewModel.clearData()
    }

        */