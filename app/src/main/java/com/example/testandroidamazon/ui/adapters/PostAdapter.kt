package com.example.testandroidamazon.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testandroidamazon.databinding.ItemBinding
import kotlinx.android.synthetic.main.item.view.*

class PostAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PostViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
      return 1
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.textView.text = "holaa"
    }

    class PostViewHolder(itemBinding: ItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
    }
}