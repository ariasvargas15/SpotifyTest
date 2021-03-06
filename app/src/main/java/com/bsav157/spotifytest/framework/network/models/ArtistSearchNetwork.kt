package com.bsav157.spotifytest.framework.network.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArtistSearchNetwork(
    @SerializedName("items") val artists: List<ArtistNetwork>,
    @SerializedName("limit") val limit: Int,
    @SerializedName("offset") val offset: Int,
) : Parcelable