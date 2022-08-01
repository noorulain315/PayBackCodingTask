package com.example.domain.usecases


import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.example.domain.models.ImageModel
import com.example.domain.repositries.ImagesRepository

class GetImagesUseCase(private val imagesRepository: ImagesRepository) {
    suspend fun invoke(searchQuery: String): LiveData<PagingData<ImageModel>> {
        return imagesRepository.getAllImages(searchQuery)
    }
}