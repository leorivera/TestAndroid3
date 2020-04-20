package com.example.testandroidamazon.repositories

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.example.testandroidamazon.api.ApiClient
import com.example.testandroidamazon.api.ChildrenData
import com.example.testandroidamazon.api.Data
import com.example.testandroidamazon.api.ITopService
import com.example.testandroidamazon.viewdata.PostViewData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.text.DateFormat
import java.util.*

import kotlin.coroutines.CoroutineContext

class DataSourcePost(coroutineContext: CoroutineContext) :
    PageKeyedDataSource<String, PostViewData>() {
    private val _service = ApiClient.getService(ITopService::class.java)
    private val job = Job()
    private val scope = CoroutineScope(coroutineContext + job)

    override fun loadInitial(
        params: LoadInitialParams<String>,
        callback: LoadInitialCallback<String, PostViewData>
    ) {
        scope.launch {
            try {
                val result = _service.requestTop()
                when {
                    result.isSuccessful -> {
                        val listing = result.body()?.data
                        callback.onResult(
                            createListPostViewData(listing)?: listOf(), listing?.before, listing?.after)
                    }
                }
            } catch (exception: Exception) {
                Log.e("DataSourcePost", "Failed to fetch data!-loadInitial")
            }
        }
    }

    override fun loadAfter(
        params: LoadParams<String>,
        callback: LoadCallback<String, PostViewData>
    ) {
        scope.launch {
            try {
                val result =
                    _service.requestTop(after = params.key)
                when {
                    result.isSuccessful -> {
                        val listing = result.body()?.data
                        callback.onResult(
                            createListPostViewData(listing) ?: listOf(),
                            listing?.after
                        )
                    }
                }
            } catch (exception: Exception) {
                Log.e("DataSourcePost", "Failed to fetch data!-loadAfter")
            }
        }
    }

    override fun loadBefore(
        params: LoadParams<String>,
        callback: LoadCallback<String, PostViewData>
    ) {
        scope.launch {
            try {
                val result =
                    _service.requestTop(before = params.key)
                when {
                    result.isSuccessful -> {
                        val listing = result.body()?.data
                        callback.onResult(
                            createListPostViewData(listing)?: listOf(), listing?.after)
                    }
                }
            } catch (exception: Exception) {
                Log.e("DataSourcePost", "Failed to fetch data!-loadBefore")
            }
        }
    }

    override fun invalidate() {
        super.invalidate()
        job.cancel()
    }

    fun createListPostViewData(listing: Data?): MutableList<PostViewData> {
        val items = listing?.children?.map { it.data }
        val _listPost: MutableList<PostViewData> = mutableListOf<PostViewData>()
        items?.forEach { children ->
            _listPost.add(createPostViewData(children))
        }
        return _listPost
    }

    fun createPostViewData(childrenData: ChildrenData): PostViewData {
        val id: String = childrenData.id
        val title: String = childrenData.title
        val author: String = childrenData.author
        val date: String = calculateDate(childrenData.date)
        val numComment: String = childrenData.numComment.toString()
        val urlImage: String = childrenData.urlImage
        return (PostViewData(id, title, author, date, numComment, urlImage))
    }

    fun calculateDate(date: Long): String {
        var result = ""
        var differenceTime = Date().time - Date(date * 1000).time
        if ((differenceTime / (1000 * 3600 * 24)) <= 0) {
            val hours: Long = differenceTime / 3600000
            result = hours.toString() + "h"
        } else {
            result = DateFormat.getDateTimeInstance().format(Date(date * 1000))
        }
        return result
    }
}