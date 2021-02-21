package com.bsav157.spotifytest.framework.di

import com.bsav157.spotifytest.data.sources.RemoteSource
import com.bsav157.spotifytest.framework.network.ApiService
import com.bsav157.spotifytest.framework.network.RetrofitDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun remoteDataSourceProvider(apiService: ApiService): RemoteSource =
        RetrofitDataSource(apiService)
}