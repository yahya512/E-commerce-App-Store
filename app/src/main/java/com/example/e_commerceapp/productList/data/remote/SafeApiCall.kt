package com.example.e_commerceapp.productList.data.remote

import com.example.e_commerceapp.productList.data.model.ApiService
import com.example.e_commerceapp.productList.domain.model.ApiResultStatus
import retrofit2.HttpException
import java.io.IOException

suspend fun <T> safeApiCall(apiCall: suspend () -> ApiService<T>): ApiResultStatus<T> {
    return try {
        val response = apiCall()
        if (response.data != null) {
            ApiResultStatus.Success(response.data)
        } else {
            ApiResultStatus.Error(
                response.message ?: "Unknown Error"
            ) // catch error message from backend
        }
    } catch (e: IOException) {
        ApiResultStatus.Error(e.message ?: "Connection Failed")
    } catch (e: HttpException) {
        ApiResultStatus.Error(e.message())
    } catch (e: Exception) {
        ApiResultStatus.Error(e.message ?: "UnKnown Error")
    }
}




