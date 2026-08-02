package com.example.e_commerceapp.productdetails.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerceapp.productdetails.domain.mapper.MapProductModelToProductUi
import com.example.e_commerceapp.productdetails.domain.usecase.GetProductByIdUseCase
import com.example.e_commerceapp.productdetails.presentation.model.ProductsDetailsStates
import com.example.e_commerceapp.productlist.domain.model.ApiResultStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
    val getProductByIdUseCase: GetProductByIdUseCase,
) : ViewModel() {

    // DetailsStateFlow
    private val _stateFlowDetails =
        MutableStateFlow<ProductsDetailsStates>(ProductsDetailsStates.Loading)
    val stateFlowDetails: StateFlow<ProductsDetailsStates> = _stateFlowDetails.asStateFlow()

    //    var productId = 0
    fun getProductById(productId: Int) {
        Log.d("id", "$productId")
        viewModelScope.launch {
            _stateFlowDetails.emit(ProductsDetailsStates.Loading)

            when (val result = getProductByIdUseCase(productId)) {
                is ApiResultStatus.Success -> {
                    _stateFlowDetails.emit(
                        ProductsDetailsStates.Success(
                            MapProductModelToProductUi.mapToUi(
                                result.data
                            )
                        )
                    )
                }

                is ApiResultStatus.Error -> {
                    _stateFlowDetails.emit(
                        ProductsDetailsStates.Error(result.errorMessage)
                    )
                }
            }
        }
    }

}