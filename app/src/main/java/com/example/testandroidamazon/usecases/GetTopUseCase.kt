package com.example.testandroidamazon.usecases

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.testandroidamazon.api.ChildrenData
import com.example.testandroidamazon.repositories.ITopRepository
import com.example.testandroidamazon.viewdata.PostViewData

class GetTopUseCase(private val _topRepository: ITopRepository) {

   fun initializedPagedListBuilder(): LiveData<PagedList<PostViewData>> = _topRepository.initializedPagedListBuilder()
}