package com.example.testandroidamazon.api

import com.google.gson.annotations.SerializedName

data class ResponsePost(val data: Data)
data class Data(val children: List<Children>, val after: String?, val before: String?)
data class Children(val data: ChildrenData)
data class ChildrenData(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("author")
    val author: String,
    @SerializedName("created_utc")
    val date: Long,
    @SerializedName("num_comments")
    val numComment: Int,
    @SerializedName("thumbnail")
    val urlImage: String
)