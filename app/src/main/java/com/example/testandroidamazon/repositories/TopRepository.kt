package com.example.testandroidamazon.repositories

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.testandroidamazon.viewdata.PostViewData
import kotlinx.coroutines.Dispatchers

class TopRepository : ITopRepository {

    val config = PagedList.Config.Builder()
        .setPageSize(30)
        .setEnablePlaceholders(false)
        .build()

    override fun initializedPagedListBuilder(): LiveData<PagedList<PostViewData>> {
        return livePagedListBuilder().build()
    }

    private fun livePagedListBuilder():
            LivePagedListBuilder<String, PostViewData> {

        val dataSourceFactory = object : DataSource.Factory<String, PostViewData>() {
            override fun create(): DataSource<String, PostViewData> {
                return DataSourcePost(Dispatchers.IO)
            }
        }
        return LivePagedListBuilder<String, PostViewData>(dataSourceFactory, config)
    }
}