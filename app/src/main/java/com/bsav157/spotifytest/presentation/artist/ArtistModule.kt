package com.bsav157.spotifytest.presentation.artist

import androidx.fragment.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@InstallIn(FragmentComponent::class)
@Module
abstract class ArtistModule {
    @Binds
    abstract fun bindArtist(fragment: ArtistFragment): IArtist.View

    @Binds
    abstract fun bindPresenter(impl: ArtistPresenter): IArtist.Presenter
}


@Module
@InstallIn(FragmentComponent::class)
object FragmentArtistModule {
    @Provides
    fun bindSearch(fragment: Fragment): ArtistFragment {
        return fragment as ArtistFragment
    }
}