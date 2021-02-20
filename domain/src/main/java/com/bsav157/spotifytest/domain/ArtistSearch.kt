package com.bsav157.spotifytest.domain

data class ArtistSearch(
    val artists: List<Artist>,
    val limit: Int,
    val offset: Int,
)
