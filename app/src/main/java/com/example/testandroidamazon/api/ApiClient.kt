package com.example.testandroidamazon.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    val _loggingInterceptor = HttpLoggingInterceptor()
    val _httpClient = OkHttpClient.Builder()
    private val _retrofit by lazy { initializeRetrofit() }

    fun initializeRetrofit(): Retrofit {
        _loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        _httpClient.addInterceptor(_loggingInterceptor)

        return Retrofit.Builder()
            .baseUrl("https://www.reddit.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(_httpClient.build())
            .build()
    }

    fun <T> getService(serviceClass: Class<T>): T = _retrofit.create(serviceClass)
}