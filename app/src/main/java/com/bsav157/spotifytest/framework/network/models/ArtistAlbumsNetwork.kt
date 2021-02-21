package com.bsav157.spotifytest.framework.network.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArtistAlbumsNetwork(
    @SerializedName("items") val albums: List<AlbumNetwork>,
    @SerializedName("limit") val limit: Int,
    @SerializedName("offset") val offset: Int,
    @SerializedName("total") val total: Int,
    @SerializedName("next") val next: String,
    @SerializedName("previous") val previous: String,
) : Parcelable