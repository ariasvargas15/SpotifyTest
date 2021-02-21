package com.bsav157.spotifytest.usecases

import com.bsav157.spotifytest.data.repositories.SpotifyRepository
import com.bsav157.spotifytest.domain.SearchParams

class GetAlbumsByArtist (private val spotifyRepository: SpotifyRepository) {
    suspend fun invoke(
        query: String,
        includedGroups: Array<String>,
        searchParams: SearchParams
    ) = spotifyRepository.getAlbumsByArtist(query, includedGroups, searchParams)
}