package com.example.paybackcodingtask.ui.viewmodels

import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.domain.models.ImageModel
import com.example.domain.usecases.GetImagesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ImagesViewModel @Inject constructor(private val getImagesUseCase: GetImagesUseCase) :
    ViewModel() {

    suspend fun getImages(searchString: String): LiveData<PagingData<ImageModel>> {
        return getImagesUseCase.invoke(searchString).cachedIn(viewModelScope)
    }
}