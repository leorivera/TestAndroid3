package com.example.testandroidamazon.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ITopService {
    @GET("top.json")
    suspend fun requestTop(
        @Query("after") after: String? = null): Response<ResponsePost>
}