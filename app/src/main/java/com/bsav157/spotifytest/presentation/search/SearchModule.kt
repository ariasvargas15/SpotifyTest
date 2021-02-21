package com.bsav157.spotifytest.presentation.search

import androidx.fragment.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@InstallIn(FragmentComponent::class)
@Module
abstract class SearchModule {
    @Binds
    abstract fun bindSearch(fragment: SearchFragment): ISearch.View

    @Binds
    abstract fun bindPresenter(impl: SearchPresenter): ISearch.Presenter
}


@Module
@InstallIn(FragmentComponent::class)
object FragmentSearchModule {
    @Provides
    fun bindSearch(fragment: Fragment): SearchFragment {
        return fragment as SearchFragment
    }
}