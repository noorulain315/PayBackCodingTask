package com.example.domain.repositries


import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.domain.models.ImageModel


interface ImagesRepository {
    suspend fun getAllImages(searchQuery: String): LiveData<PagingData<ImageModel>>
}