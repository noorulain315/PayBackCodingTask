package com.example.data.repositories


import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.core.utils.Constants.PAGE_SIZE
import com.example.data.datasource.ImageDataSource
import com.example.domain.models.ImageModel
import com.example.data.remote.ImageApiService
import com.example.domain.repositries.ImagesRepository
import javax.inject.Inject

class ImagesRepositoryImp @Inject constructor(private val imageApiService: ImageApiService) :
    ImagesRepository {
    override suspend fun getAllImages(searchQuery: String): LiveData<PagingData<ImageModel>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = PAGE_SIZE),
            pagingSourceFactory = {
                ImageDataSource(imageApiService, searchQuery)
            }
        ).liveData
    }
}