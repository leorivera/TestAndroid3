package com.example.testandroidamazon.usecases

import com.example.testandroidamazon.dtos.PostDTO
import com.example.testandroidamazon.repositories.IRepository

class GetTopUseCase(private val _repository: IRepository) {

   fun initializedPagedListBuilder(): PostDTO = _repository.initializedPagedListBuilder()
}