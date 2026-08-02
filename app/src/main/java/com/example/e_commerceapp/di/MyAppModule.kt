package com.example.e_commerceapp.di

import com.example.e_commerceapp.BuildConfig
import com.example.e_commerceapp.productdetails.data.remote.ProductDetailsApi
import com.example.e_commerceapp.productdetails.data.repository.ProductDetailsRepositoryImpl
import com.example.e_commerceapp.productdetails.domain.repository.ProductDetailsRepository
import com.example.e_commerceapp.productdetails.domain.usecase.GetProductByIdUseCase
import com.example.e_commerceapp.productlist.data.remote.ProductListApi
import com.example.e_commerceapp.productlist.data.repository.ProductListRepositoryImpl
import com.example.e_commerceapp.productlist.domain.repository.ProductListRepository
import com.example.e_commerceapp.productlist.domain.usecase.GetAllProductUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Locale
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MyAppModule {

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
        val client =
            OkHttpClient.Builder()
                .addInterceptor(logging)
                .addInterceptor { chain ->
                    val request = chain.request()
                        .newBuilder()
                        .addHeader("lang", Locale.getDefault().language)
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
    fun provideRepoGetAllUseCase(apiService: ProductListApi): ProductListRepository {
        return ProductListRepositoryImpl(apiService)
    }

    // inject ProductDetailsRepository in USE CASE Details
    @Provides
    fun provideRepoGetProductByIdUseCase(apiServices: ProductDetailsApi): ProductDetailsRepository {
        return ProductDetailsRepositoryImpl(apiServices)
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

}