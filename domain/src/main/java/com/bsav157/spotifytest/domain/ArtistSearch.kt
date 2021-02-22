package com.bsav157.spotifytest.domain

import java.io.Serializable

data class ArtistSearch(
    val artists: List<Artist>,
    val limit: Int,
    val offset: Int,
): Serializable
