package com.bsav157.spotifytest.framework.network.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImageNetwork(
    @SerializedName("height") val height: Int,
    @SerializedName("width") val width: Int,
    @SerializedName("url") val url: String,
) : Parcelable