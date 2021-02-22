package com.bsav157.spotifytest.presentation.artist

import com.bsav157.spotifytest.domain.Album

interface OnClickAlbum {
    fun onClick(album: Album)
}