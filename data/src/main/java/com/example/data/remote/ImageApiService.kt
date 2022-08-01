package com.example.data.remote

import com.example.data.models.remote.ImageRemoteModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageApiService {
    @GET("api/")
    suspend fun getAllImages(
        @Query("q") searchString: String? = null,
        @Query("per_page") per_page: Int? = null,
        @Query("page") page: Int? = null,
    ): ImageRemoteModel
}