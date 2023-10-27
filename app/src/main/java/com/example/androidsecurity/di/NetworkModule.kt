package com.example.androidsecurity.di


import com.example.androidsecurity.API_TIMEOUT_SECONDS
import com.example.androidsecurity.BASE_URL
import com.example.androidsecurity.data.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * This is the Dagger Hilt module that provides the dependencies for the app.
 * [NetworkModule] provides [ApiService] related network dependencies
 */
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(provideOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(): ApiService = retrofit.create(ApiService::class.java)

    private fun provideOkHttpClient(): OkHttpClient = OkHttpClient().newBuilder()
        .callTimeout(API_TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .connectTimeout(API_TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .readTimeout(API_TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .writeTimeout(API_TIMEOUT_SECONDS, TimeUnit.SECONDS)
        .addInterceptor(provideLoggingInterceptor())
        .build()

    private fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

}