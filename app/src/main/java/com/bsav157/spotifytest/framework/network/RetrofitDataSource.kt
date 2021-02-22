package com.bsav157.spotifytest.framework.network

import com.bsav157.spotifytest.data.sources.RemoteSource
import com.bsav157.spotifytest.domain.ArtistAlbums
import com.bsav157.spotifytest.domain.Search
import com.bsav157.spotifytest.domain.SearchParams
import com.bsav157.spotifytest.framework.network.converters.convertToDomain

class RetrofitDataSource constructor(private val apiService: ApiService) : RemoteSource {

    override suspend fun doSearch(
        query: String,
        type: Array<String>,
        searchParams: SearchParams
    ): Search =
        apiService.doSearch(
            query,
            type,
            searchParams.market,
            searchParams.limit,
            searchParams.offset
        ).convertToDomain()

    override suspend fun getAlbumsByArtist(
        artistId: String,
        includedGroups: Array<String>,
        searchParams: SearchParams
    ): ArtistAlbums =
        apiService.getAlbumsByArtist(
            artistId,
            includedGroups,
            searchParams.market,
            searchParams.limit,
            searchParams.offset
        ).convertToDomain()
}