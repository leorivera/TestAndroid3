package com.example.testandroidamazon.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testandroidamazon.R
import com.example.testandroidamazon.ui.adapters.PostAdapter
import com.example.testandroidamazon.viewmodels.MainViewModel
import com.example.testandroidamazon.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private lateinit var _binding: FragmentMainBinding
    private lateinit var _viewModel: MainViewModel
    private var _postAdapter = PostAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        _binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_main, container, false)
        setupBindig()
        setupRecyclerView()
        return _binding.root
    }

    fun setupBindig() {
        _binding.apply {
            lifecycleOwner = this.lifecycleOwner
            viewModel = _viewModel
        }
    }

    fun setupRecyclerView() {
        _binding.mainRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this.context)
            adapter = _postAdapter
        }
    }
}