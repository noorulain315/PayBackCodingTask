package com.example.paybackcodingtask.di.module

import com.example.domain.repositries.ImagesRepository
import com.example.domain.usecases.GetImagesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    @Singleton
    fun provideGetImageUseCase(imagesRepository: ImagesRepository) =
        GetImagesUseCase(imagesRepository)
}