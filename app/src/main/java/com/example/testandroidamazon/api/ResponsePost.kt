package com.example.testandroidamazon.api

import com.google.gson.annotations.SerializedName

data class ResponsePost(
    @SerializedName("")
    val avatarUser: String,
    @SerializedName("")
    val nameUser: String,
    @SerializedName("")
    val postTime: String,
    @SerializedName("")
    val award: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("")
    val postImage: String
)