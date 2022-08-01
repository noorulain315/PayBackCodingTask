package com.example.data.models.remote

import com.example.domain.models.ImageModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImageRemoteModel(
    @Json(name = "hits")
    val imagesList: List<ImageModel>
)
