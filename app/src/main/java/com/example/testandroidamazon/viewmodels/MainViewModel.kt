package com.example.testandroidamazon.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.testandroidamazon.repositories.Repository
import com.example.testandroidamazon.usecases.GetTopUseCase
import com.example.testandroidamazon.viewdata.PostViewData

class MainViewModel : ViewModel() {

    private var _getTopUseCase: GetTopUseCase = GetTopUseCase(Repository())
    private var _listPost: LiveData<PagedList<PostViewData>>
    private var _progress: LiveData<Boolean>

    init {
        val postDTO = _getTopUseCase.initializedPagedListBuilder()
        _listPost = postDTO.postsLiveData
        _progress = postDTO._progress
    }

    fun getListPost(): LiveData<PagedList<PostViewData>> = _listPost
    fun getProgress(): LiveData<Boolean> = _progress

}