package com.example.testandroidamazon.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private val loggingInterceptor = HttpLoggingInterceptor()
    private val httpClient = OkHttpClient.Builder()
    private val retrofit = Retrofit.Builder()

    init {
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        httpClient.addInterceptor(loggingInterceptor)
        retrofit
            .baseUrl("hola")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
    }

}