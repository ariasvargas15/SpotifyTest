package com.bsav157.spotifytest.presentation.commons

import java.text.NumberFormat
import java.util.*

fun formatNumber(followers: Int) : String{
    return NumberFormat.getNumberInstance(Locale.US).format(followers)
}