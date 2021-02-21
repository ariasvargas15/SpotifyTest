package com.bsav157.spotifytest.network.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AlbumNetwork(
    @SerializedName("id") val id: String,
    @SerializedName("images") val images: List<ImageNetwork>,
    @SerializedName("name") val name: String,
    @SerializedName("total_tracks") val totalTracks: Int,
    @SerializedName("uri") val uri: String,
    @SerializedName("available_markets") val markets: List<String>,
    @SerializedName("external_urls") val url: ExternalUrlNetwork,
) : Parcelable
