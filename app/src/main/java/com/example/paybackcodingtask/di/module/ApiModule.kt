package com.example.paybackcodingtask.di.module

import android.app.Application
import com.example.core.utils.Constants.CACHE
import com.example.core.utils.Constants.IMAGE_TYPE
import com.example.core.utils.Constants.KEY
import com.example.data.remote.ImageApiService
import com.example.paybackcodingtask.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Singleton
    fun providesOkHttpClient(cache: Cache): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(apiInterceptor)
            .addInterceptor(cacheInterceptor)
            .cache(cache)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
        return okHttpClient.build()
    }

    private val apiInterceptor = Interceptor { chain ->
        val request = chain.request().newBuilder()
        val originalHttpUrl = chain.request().url()
        val url = originalHttpUrl.newBuilder()
            .addQueryParameter(KEY, BuildConfig.API_KEY)
            .addQueryParameter(IMAGE_TYPE.first, IMAGE_TYPE.second)
            .build()
        request.url(url)
        chain.proceed(request.build())
    }

    private val cacheInterceptor = Interceptor { chain ->
        val response: Response = chain.proceed(chain.request())
        val cacheControl = CacheControl.Builder()
            .maxAge(30, TimeUnit.DAYS)
            .build()
        response.newBuilder()
            .header("Cache-Control", cacheControl.toString())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): ImageApiService = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_API_URL)
        .client(okHttpClient)
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
            )
        )
        .build()
        .create(ImageApiService::class.java)

    @Provides
    @Singleton
    fun provideCache(app: Application): Cache {
        return Cache(
            File(app.applicationContext.cacheDir, CACHE),
            10485760L
        )
    }
}