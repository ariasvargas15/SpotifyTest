package com.bsav157.spotifytest.network.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ExternalUrlNetwork(
    @SerializedName("spotify") val spotifyUrl: String,
) : Parcelable