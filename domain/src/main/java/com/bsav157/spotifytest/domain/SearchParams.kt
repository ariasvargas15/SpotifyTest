package com.bsav157.spotifytest.domain

data class SearchParams(
    val market: List<String>,
    val limit: Int,
    val offset: Int,
)