package com.bsav157.spotifytest.usecases

import com.bsav157.spotifytest.data.repositories.SpotifyRepository
import com.bsav157.spotifytest.domain.SearchParams

class DoSearch(private val spotifyRepository: SpotifyRepository) {
    suspend fun invoke(
        query: String,
        type: Array<String>,
        searchParams: SearchParams
    ) = spotifyRepository.doSearch(query, type, searchParams)
}