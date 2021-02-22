package com.bsav157.spotifytest.presentation.artist

import com.bsav157.spotifytest.domain.ArtistAlbums

class IArtist {
    interface View {
        fun showAlbums(artistAlbums: ArtistAlbums)
    }

    interface Presenter {
        fun getAlbums(idArtist: String)
    }
}