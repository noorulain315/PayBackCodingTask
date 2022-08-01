package com.example.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.core.utils.Constants.FIRST_PAGE
import com.example.domain.models.ImageModel
import com.example.data.remote.ImageApiService
import java.io.IOException

class ImageDataSource(
    private val imageApiService: ImageApiService,
    private val queryString: String,
) :
    PagingSource<Int, ImageModel>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ImageModel> {
        val page = params.key ?: FIRST_PAGE
        return try {
            val data = imageApiService.getAllImages(queryString, params.loadSize, page)

            LoadResult.Page(
                data = data.imagesList,
                prevKey = if (page == FIRST_PAGE) null else page - 1,
                nextKey = if (data.imagesList.isEmpty()) null else page + 1
            )
        } catch (t: Throwable) {
            var exception = t
            if (t is IOException) {
                exception = IOException("Please check your internet connection and try again")
            }

            LoadResult.Error(exception)
        }

    }

    override fun getRefreshKey(state: PagingState<Int, ImageModel>): Int? {
        return state.anchorPosition
    }
}