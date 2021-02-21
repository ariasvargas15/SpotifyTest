package com.bsav157.spotifytest.domain

import java.io.Serializable

data class Album(
    val id: String,
    val images: List<Image>,
    val name: String,
    val totalTracks: Int,
    val uri: String,
    val markets: List<String>,
    val url: ExternalUrl,
) : Serializable
