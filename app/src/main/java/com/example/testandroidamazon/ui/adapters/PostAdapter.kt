package com.example.testandroidamazon.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.testandroidamazon.R
import com.example.testandroidamazon.databinding.ItemBinding
import com.example.testandroidamazon.api.ResponsePost

class PostAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PostViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return 2
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val hola =
            ResponsePost(
                "leonardo",
                "leorivera",
                "asasfafaf",
                "safasasa",
                "sdsafasfa",
                "safafasfas"
            )
        if (holder is PostViewHolder)
            holder.itemBinding.post = hola
    }

    class PostViewHolder(val itemBinding: ItemBinding) : RecyclerView.ViewHolder(itemBinding.root)
}