package com.example.testandroidamazon.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testandroidamazon.R
import com.example.testandroidamazon.databinding.ItemBinding
import com.example.testandroidamazon.viewdata.PostViewData

class PostAdapter(private var _onClick: IPostAdapterOnClickListener) :
    PagedListAdapter<PostViewData, PostAdapter.PostViewHolder>(DiffUtilCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {

        val binding: ItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item,
            parent,
            false
        )
        binding.onClick = _onClick
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        getItem(position)?.let { holder.itemBinding.post = it }
    }

    class PostViewHolder(val itemBinding: ItemBinding) : RecyclerView.ViewHolder(itemBinding.root)
}