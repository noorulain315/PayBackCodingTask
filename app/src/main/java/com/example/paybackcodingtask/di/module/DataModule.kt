package com.example.paybackcodingtask.di.module

import com.example.data.remote.ImageApiService
import com.example.data.repositories.ImagesRepositoryImp
import com.example.domain.repositries.ImagesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    fun providesImageRepository(apiService: ImageApiService): ImagesRepository {
        return ImagesRepositoryImp(apiService)
    }
}