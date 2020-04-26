package com.example.testandroidamazon.dtos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.example.testandroidamazon.viewdata.PostViewData

class PostDTO {
    lateinit var postsLiveData: LiveData<PagedList<PostViewData>>
     var _progress = MutableLiveData<Boolean>()
}