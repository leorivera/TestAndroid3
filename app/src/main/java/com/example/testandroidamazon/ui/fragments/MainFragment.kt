package com.example.testandroidamazon.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testandroidamazon.databinding.FragmentMainBinding
import com.example.testandroidamazon.ui.adapters.PostAdapter


class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private var _postAdapter = PostAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        setupRecyclerView()
        return _binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun setupRecyclerView() {
        _binding?.mainRecyclerView?.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this.context)
            adapter = _postAdapter
        }
    }
}