package com.example.data

import androidx.paging.PagingSource
import com.example.data.datasource.ImageDataSource
import com.example.data.models.remote.ImageRemoteModel
import com.example.data.remote.ImageApiService
import com.example.domain.models.ImageModel
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.junit.*
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class ImagesDataSourceTest : BaseTest() {


    @MockK
    private lateinit var apiService: ImageApiService
    private lateinit var imageDataSource: ImageDataSource
    private lateinit var imageRemoteModel: ImageRemoteModel

    @Before
    fun setUp() {
        imageRemoteModel = ImageRemoteModel(getTestData())
        imageDataSource = ImageDataSource(apiService, "fruits")

    }

    @Test
    fun load_images_success() = runBlocking {

        coEvery { apiService.getAllImages("fruits", any(), any()) } returns (imageRemoteModel)

        Assert.assertThat(
            imageDataSource.load(
                PagingSource.LoadParams.Refresh(
                    key = null,
                    loadSize = 20,
                    placeholdersEnabled = false
                )
            ),
            CoreMatchers.equalTo(
                PagingSource.LoadResult.Page(
                    data = getTestData(),
                    prevKey = null,
                    nextKey = 2
                )
            ),
        )

    }


    private fun getTestData() = listOf(
        ImageModel(
            id = 1,
            largeImageURL = "test url",
            previewURL = "test url",
            likes = 1,
            tags = "test tag",
            user = "carlos",
            user_id = 1,
            views = 2,
            comments = 3,
            downloads = 6,
        )
    )
}