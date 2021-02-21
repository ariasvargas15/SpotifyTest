package com.bsav157.spotifytest.data.sources

import com.bsav157.spotifytest.domain.ArtistAlbums
import com.bsav157.spotifytest.domain.Search
import com.bsav157.spotifytest.domain.SearchParams

interface RemoteSource {

    suspend fun doSearch(
        query: String,
        type: Array<String>,
        searchParams: SearchParams
    ): Search

    suspend fun getAlbumsByArtist(
        artistId: String,
        includedGroups: Array<String>,
        searchParams: SearchParams
    ): ArtistAlbums

}