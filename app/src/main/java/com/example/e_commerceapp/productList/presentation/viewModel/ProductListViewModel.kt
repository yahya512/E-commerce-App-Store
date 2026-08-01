package com.example.e_commerceapp.productList.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerceapp.productList.domain.mapper.ProductListUIMapper
import com.example.e_commerceapp.productList.domain.model.ApiResultStatus
import com.example.e_commerceapp.productList.domain.usecase.GetAllProductUseCase
import com.example.e_commerceapp.productList.presentation.model.ProductListStates
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class ProductListViewModel @Inject constructor(
    val getAllProductUseCase: GetAllProductUseCase,

    ) : ViewModel() {
    //ListStatFlow
    private val _stateFlowList = MutableStateFlow<ProductListStates>(ProductListStates.Loading)
    val stateFlowList: StateFlow<ProductListStates> = _stateFlowList.asStateFlow()
    fun getAllProduct() {
        viewModelScope.launch {
            _stateFlowList.emit(ProductListStates.Loading)


            when (val result = getAllProductUseCase()) {
                is ApiResultStatus.Error -> {
                    _stateFlowList.emit(ProductListStates.Error(result.errorMessage))
                }

                is ApiResultStatus.Success -> {
                    _stateFlowList.emit(
                        ProductListStates.Success(
                            ProductListUIMapper.mapToDomainList(
                                result.data
                            )
                        )
                    )
                }
            }
        }
    }
}





