package com.example.testandroidamazon.ui.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.testandroidamazon.viewdata.PostViewData

class DiffUtilCallBack(): DiffUtil.ItemCallback<PostViewData>() {
    override fun areItemsTheSame(oldItem: PostViewData, newItem: PostViewData): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: PostViewData, newItem: PostViewData): Boolean =
        oldItem == newItem
}

