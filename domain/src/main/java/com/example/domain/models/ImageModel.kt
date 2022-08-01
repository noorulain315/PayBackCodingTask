package com.example.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImageModel(
    val id: Int,
    val largeImageURL: String,
    val previewURL: String,
    val likes: Int,
    val tags: String,
    val user: String,
    val user_id: Int,
    val views: Int,
    val comments: Int,
    val downloads: Int,
) : Parcelable
