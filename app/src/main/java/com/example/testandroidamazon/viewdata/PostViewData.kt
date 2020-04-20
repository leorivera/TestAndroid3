package com.example.testandroidamazon.viewdata

import android.os.Parcelable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PostViewData(
    val id: String,
    val title: String,
    val author: String,
    val date: String,
    val numComment: String,
    val imageUrl: String
): Parcelable

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String) {
    Glide.with(view.context)
        .load(url)
        .into(view)
}

