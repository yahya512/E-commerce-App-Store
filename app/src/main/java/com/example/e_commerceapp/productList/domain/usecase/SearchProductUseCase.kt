package com.example.e_commerceapp.productList.domain.usecase


//class SearchProductUseCase @Inject constructor(private val repository: ProductListRepository) {
//    suspend operator fun invoke(query: String): ApiResultStatus<List<ProductDomainModel>?> {
//        return when (val result = repository.getAllProducts()) {
//            is ApiResultStatus.Error -> {
//                ApiResultStatus.Error(result.errorMessage)
//            }
//
//            is ApiResultStatus.Success -> {
//                ApiResultStatus.Success(result.data)
//            }
//        }
//    }
//}