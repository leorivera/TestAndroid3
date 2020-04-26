package com.example.testandroidamazon.repositories.datasource

import android.util.Log
import androidx.lifecycle.MutableLiveData
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

class PostDataSource(coroutineContext: CoroutineContext) :
    PageKeyedDataSource<String, PostViewData>() {
    private val _service = ApiClient.getService(ITopService::class.java)
    private val job = Job()
    private val scope = CoroutineScope(coroutineContext + job)
    var _progress = MutableLiveData<Boolean>(true)

    fun getProgress(): MutableLiveData<Boolean> = _progress

    override fun loadInitial(
        params: LoadInitialParams<String>,
        callback: LoadInitialCallback<String, PostViewData>
    ) {
        scope.launch {
            _progress.postValue(true)
            try {
                val result = _service.requestTop()
                if (result.isSuccessful) {
                    val listing = result.body()?.data
                    callback.onResult(createListPostViewData(listing) ?: listOf(),
                                        listing?.before,
                                        listing?.after)
                } else {
                    Log.e("DataSourcePost", result.message())
                }
            } catch (exception: Exception) {
                Log.e("Failed data loadInitial", exception.message.toString())
            }
            _progress.postValue(false)
        }
    }

    override fun loadAfter(
        params: LoadParams<String>,
        callback: LoadCallback<String, PostViewData>
    ) {
        scope.launch {
            _progress.postValue(true)
            try {
                val result = _service.requestTop(after = params.key)
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
                Log.e("Failed data loadAfter", exception.message.toString())
            }
            _progress.postValue(false)
        }
    }

    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<String, PostViewData>) { }

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

    override fun invalidate() {
        super.invalidate()
        job.cancel()
    }

}