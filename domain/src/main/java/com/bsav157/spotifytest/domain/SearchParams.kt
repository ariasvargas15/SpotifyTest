package com.bsav157.spotifytest.domain

data class SearchParams(
    val market: Array<String>,
    val limit: Int,
    val offset: Int,
)