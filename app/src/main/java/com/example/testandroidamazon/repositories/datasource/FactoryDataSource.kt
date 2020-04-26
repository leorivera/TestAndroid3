package com.example.testandroidamazon.repositories.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.testandroidamazon.viewdata.PostViewData
import kotlinx.coroutines.Dispatchers


class FactoryDataSource() : DataSource.Factory<String, PostViewData>() {

    val postDataSource: PostDataSource = PostDataSource(Dispatchers.IO)

    override fun create(): DataSource<String, PostViewData> {
        return postDataSource
    }

    fun getProgress(): MutableLiveData<Boolean> = postDataSource.getProgress()
}