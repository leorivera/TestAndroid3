package com.example.testandroidamazon.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testandroidamazon.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private var mBinding: FragmentMainBinding? = null
    private val binding get() = mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentMainBinding.inflate(inflater, container, false)
        setupRecyclerView()
        return mBinding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

    fun setupRecyclerView() {
        mBinding?.mainRecyclerView?.setHasFixedSize(true)
        mBinding?.mainRecyclerView?.setLayoutManager(LinearLayoutManager(this.context))
    }
}