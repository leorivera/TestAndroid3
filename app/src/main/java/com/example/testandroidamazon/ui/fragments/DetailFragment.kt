package com.example.testandroidamazon.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.testandroidamazon.R
import com.example.testandroidamazon.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private lateinit var _binding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_detail, container, false)
        _binding.lifecycleOwner = this
        _binding.detailPost = arguments?.let { DetailFragmentArgs.fromBundle(it).item }
        return _binding.root
    }
}
