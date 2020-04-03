package com.example.testandroidamazon.api

import okhttp3.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ITopService {
    @GET("top.json")
    fun requestTop():Call


    companion object{
        operator fun invoke() : ITopService {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.simplifiedcoding.in/course-apis/recyclerview/")
                .build()
                .create(ITopService::class.java)
        }
    }

}