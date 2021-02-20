package com.bsav157.spotifytest.domain

data class Artist(
    val id: String,
    val followers: Followers,
    val genres: List<String>,
    val images: List<Image>,
    val name: String,
    val popularity: Int,
    val uri: String,
)
