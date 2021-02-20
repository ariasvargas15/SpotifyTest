package com.bsav157.spotifytest.data.repositories

import com.bsav157.spotifytest.data.sources.RemoteSource
import com.bsav157.spotifytest.domain.SearchParams

class SpotifyRepository(private val remoteSource: RemoteSource) {

    suspend fun doSearch(
        query: String,
        type: Array<String>,
        searchParams: SearchParams
    ) {
        return remoteSource.doSearch(query, type, searchParams)
    }

    suspend fun getAlbumsByArtist(
        artistId: String,
        includedGroups: Array<String>,
        searchParams: SearchParams
    ) {
        return remoteSource.getAlbumsByArtist(artistId, includedGroups, searchParams)
    }

}