package com.example.core.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.core.R

object DataBindingAdapter {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun loadImage(view: ImageView, url: String) {
        Glide.with(view.context)
            .load(url)
            .placeholder(R.drawable.ic_loading)
            .error(R.drawable.ic_loading)
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("thumbnailImageUrl")
    fun loadThumbnailImage(view: ImageView, url: String) {
        Glide.with(view.context)
            .load(url)
            .thumbnail(0.5f)
            .placeholder(R.drawable.ic_loading)
            .error(R.drawable.ic_loading)
            .into(view)
    }
}