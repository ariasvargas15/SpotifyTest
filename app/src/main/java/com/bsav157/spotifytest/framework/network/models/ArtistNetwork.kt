package com.bsav157.spotifytest.framework.network.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArtistNetwork(
    @SerializedName("id") val id: String,
    @SerializedName("followers") val followers: FollowersNetwork,
    @SerializedName("genres") val genres: List<String>,
    @SerializedName("images") val images: List<ImageNetwork>,
    @SerializedName("name") val name: String,
    @SerializedName("popularity") val popularity: Int,
    @SerializedName("uri") val uri: String,
) : Parcelable