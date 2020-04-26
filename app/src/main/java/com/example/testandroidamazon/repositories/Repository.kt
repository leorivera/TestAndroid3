package com.example.testandroidamazon.repositories

import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.testandroidamazon.dtos.PostDTO
import com.example.testandroidamazon.repositories.datasource.FactoryDataSource
import com.example.testandroidamazon.viewdata.PostViewData

interface IRepository {
    fun initializedPagedListBuilder(): PostDTO
}

class Repository : IRepository {
    lateinit var factoryDataSource: FactoryDataSource
    val postDTO = PostDTO()
    val config = PagedList.Config.Builder()
        .setPageSize(30)
        .setEnablePlaceholders(false)
        .build()

    override fun initializedPagedListBuilder(): PostDTO {
        postDTO.postsLiveData = livePagedListBuilder().build()
        postDTO._progress=factoryDataSource.getProgress()
        return postDTO
    }

    private fun livePagedListBuilder(): LivePagedListBuilder<String, PostViewData> {
        factoryDataSource = FactoryDataSource()
        return LivePagedListBuilder(factoryDataSource, config)
    }
}