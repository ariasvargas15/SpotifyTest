package com.bsav157.spotifytest.domain

import java.io.Serializable

data class Image(
    val height: Int,
    val width: Int,
    val url: String,
): Serializable
