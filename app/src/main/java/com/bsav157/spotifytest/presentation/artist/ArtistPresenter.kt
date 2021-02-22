package com.bsav157.spotifytest.presentation.artist

import android.util.Log
import com.bsav157.spotifytest.domain.SearchParams
import com.bsav157.spotifytest.presentation.commons.ScopeImpl
import com.bsav157.spotifytest.usecases.GetAlbumsByArtist
import kotlinx.coroutines.launch
import javax.inject.Inject

class ArtistPresenter @Inject constructor(
    private val view: IArtist.View,
    private val getAlbumsByArtist: GetAlbumsByArtist
) : IArtist.Presenter, ScopeImpl() {

    override fun getAlbums(idArtist: String) {
        launch {
            val albums =
                getAlbumsByArtist.invoke(idArtist, arrayOf("album"), SearchParams(arrayOf(), 50, 0))
            view.showAlbums(albums)
            Log.e("something", albums.toString())
        }
    }

}