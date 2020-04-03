package com.example.testandroidamazon.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testandroidamazon.api.ResponsePost

class MainViewModel : ViewModel() {

    private val listPost = MutableLiveData<List<ResponsePost>>()

}