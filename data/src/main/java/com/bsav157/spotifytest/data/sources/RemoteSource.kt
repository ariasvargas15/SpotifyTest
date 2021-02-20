package com.bsav157.spotifytest.data.sources

import com.bsav157.spotifytest.domain.SearchParams

interface RemoteSource {

    suspend fun doSearch(
        query: String,
        type: Array<String>,
        searchParams: SearchParams
    )

    suspend fun getAlbumsByArtist(
        artistId: String,
        includedGroups: Array<String>,
        searchParams: SearchParams
    )

}