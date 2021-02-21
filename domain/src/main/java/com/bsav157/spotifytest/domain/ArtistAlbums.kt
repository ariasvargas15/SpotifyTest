package com.bsav157.spotifytest.domain

import java.io.Serializable

data class ArtistAlbums(
    val albums: List<Album>,
    val limit: Int,
    val offset: Int,
    val total: Int,
    val next: String,
    val previous: String,
): Serializable