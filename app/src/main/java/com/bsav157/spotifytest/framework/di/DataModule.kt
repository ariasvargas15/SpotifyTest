package com.bsav157.spotifytest.framework.di

import android.app.Activity
import com.bsav157.spotifytest.data.repositories.SpotifyRepository
import com.bsav157.spotifytest.data.sources.RemoteSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

      @Provides
      fun providesRepository(remoteSource: RemoteSource): SpotifyRepository = SpotifyRepository(remoteSource)

}