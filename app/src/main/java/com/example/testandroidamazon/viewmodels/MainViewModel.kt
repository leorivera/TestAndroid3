package com.example.testandroidamazon.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.testandroidamazon.repositories.TopRepository
import com.example.testandroidamazon.usecases.GetTopUseCase
import com.example.testandroidamazon.viewdata.PostViewData

class MainViewModel : ViewModel() {

    private var _getTopUseCase: GetTopUseCase = GetTopUseCase(TopRepository())
    var _listPost: LiveData<PagedList<PostViewData>>

    init {
        _listPost = _getTopUseCase.initializedPagedListBuilder()
    }

    fun getListPost(): LiveData<PagedList<PostViewData>> = _listPost
}