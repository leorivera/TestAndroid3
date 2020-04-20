package com.example.testandroidamazon.repositories

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.testandroidamazon.viewdata.PostViewData

interface ITopRepository {

    fun initializedPagedListBuilder(): LiveData<PagedList<PostViewData>>
}