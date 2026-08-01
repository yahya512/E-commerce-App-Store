package com.example.e_commerceapp.DI

import com.example.e_commerceapp.BuildConfig
import com.example.e_commerceapp.productDetails.data.remote.ProductDetailsApi
import com.example.e_commerceapp.productDetails.data.repository.ProductDetailsRepositoryImp
import com.example.e_commerceapp.productDetails.domain.repository.ProductDetailsRepository
import com.example.e_commerceapp.productDetails.domain.usecase.GetProductByIdUseCase
import com.example.e_commerceapp.productDetails.presentation.viewModel.ProductDetailsViewModel
import com.example.e_commerceapp.productList.data.remote.ProductListApi
import com.example.e_commerceapp.productList.data.repository.ProductListRepositoryImp
import com.example.e_commerceapp.productList.domain.repository.ProductListRepository
import com.example.e_commerceapp.productList.domain.usecase.GetAllProductUseCase
import com.example.e_commerceapp.productList.presentation.viewModel.ProductListViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.internal.addHeaderLenient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Locale
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MyAppModule {

    //setup OkHttp logging
    @Provides
    fun provideOkHttpLogging(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor().apply {
            level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }
        return logging
    }

    // setup OkHttp Client
    @Provides
    fun provideOkHttpClient(logging: HttpLoggingInterceptor): OkHttpClient {
        val language = Locale.getDefault().language
        val client =
            OkHttpClient.Builder()
                .addInterceptor(logging)
                .addInterceptor { chain ->
                    val request = chain.request()
                        .newBuilder()
                        .addHeader("lang", language)
                        .build()
                    chain.proceed(request)
                }
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build()
        return client
    }

    //Setup Retrofit Instance
    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://skyblue-dogfish-178203.hostingersite.com/api/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // provide instance for productList Api
    @Provides
    fun provideRetrofitInstanceList(retrofit: Retrofit): ProductListApi {
        return retrofit.create(ProductListApi::class.java)
    }

    // provide instance for productDetails Api

    @Provides
    fun provideRetrofitInstanceDetails(retrofit: Retrofit): ProductDetailsApi {
        return retrofit.create(ProductDetailsApi::class.java)
    }

    // inject ProductListRepository in USE CASE list
    @Provides
    fun provideGetAllProductUseCase(apiService: ProductListApi): ProductListRepository {
        return ProductListRepositoryImp(apiService)
    }

    // inject ProductDetailsRepository in USE CASE Details
    @Provides
    fun provideGetProductByIdUseCase(apiServices: ProductDetailsApi): ProductDetailsRepository {
        return ProductDetailsRepositoryImp(apiServices)
    }

    // inject USE Case in ProductListViewModel
    @Provides
    fun provideGetAllUseCase(repository: ProductListRepository): GetAllProductUseCase {
        return GetAllProductUseCase(repository)
    }

    // inject USE Case in ProductDetailsViewModel
    @Provides
    fun provideGetByIdUseCase(repository: ProductDetailsRepository): GetProductByIdUseCase {
        return GetProductByIdUseCase(repository)
    }

    // inject ProductListViewModel in ProductListFragment
    @Provides
    fun provideProductListViewModel(
        getAllProductUseCase: GetAllProductUseCase,
    ): ProductListViewModel {
        return ProductListViewModel(getAllProductUseCase)
    }

    // inject ProductDetailsViewModel in ProductDetailsFragment
    @Provides
    fun provideProductDetailsViewModel(
        getProductByIdUseCase: GetProductByIdUseCase,
    ): ProductDetailsViewModel {
        return ProductDetailsViewModel(getProductByIdUseCase)
    }
}