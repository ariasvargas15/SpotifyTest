package com.bsav157.spotifytest.framework.di

import com.bsav157.spotifytest.data.repositories.SpotifyRepository
import com.bsav157.spotifytest.usecases.DoSearch
import com.bsav157.spotifytest.usecases.GetAlbumsByArtist
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
class UseCasesModule {

    @Provides
    fun doSearch(spotifyRepository: SpotifyRepository): DoSearch = DoSearch(spotifyRepository)

    @Provides
    fun getAlbumsByArtist(spotifyRepository: SpotifyRepository): GetAlbumsByArtist =
        GetAlbumsByArtist(spotifyRepository)

}