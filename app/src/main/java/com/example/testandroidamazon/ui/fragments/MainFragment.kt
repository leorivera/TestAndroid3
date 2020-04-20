package com.example.testandroidamazon.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testandroidamazon.R
import com.example.testandroidamazon.databinding.FragmentMainBinding
import com.example.testandroidamazon.ui.adapters.IPostAdapterOnClickListener
import com.example.testandroidamazon.ui.adapters.PostAdapter
import com.example.testandroidamazon.viewdata.PostViewData
import com.example.testandroidamazon.viewmodels.MainViewModel

class MainFragment : Fragment(), IPostAdapterOnClickListener {

    private lateinit var _navController: NavController
    private lateinit var _binding: FragmentMainBinding
    private lateinit var _viewModel: MainViewModel
    private var _postAdapter = PostAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        _binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_main, container, false)
        setupBindig()
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        _navController = Navigation.findNavController(view)
        _viewModel.getListPost().observe(viewLifecycleOwner, Observer {
            _postAdapter.submitList(it)
        })
    }

    fun setupBindig() {
        _binding.apply {
            lifecycleOwner = this.lifecycleOwner
            viewModel = _viewModel
        }
    }

    fun setupRecyclerView() {
        _binding.mainRecyclerView.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = _postAdapter
        }
    }

    override fun detailPost(postViewData: PostViewData) {
        val action = MainFragmentDirections.actionMainFragmentToDetailFragment(postViewData)
        _navController.navigate(action)
    }
}