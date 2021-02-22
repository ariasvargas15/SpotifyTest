package com.bsav157.spotifytest.framework.network

import com.bsav157.spotifytest.framework.network.models.ArtistAlbumsNetwork
import com.bsav157.spotifytest.framework.network.models.SearchNetwork
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("search")
    suspend fun doSearch(
        @Query("q") q: String,
        @Query("type") type: Array<String>,
        @Query("market") market: Array<String>,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
    ): SearchNetwork

    @GET("artists/{id}/albums")
    suspend fun getAlbumsByArtist(
        @Path("id") id: String,
        @Query("include_groups") type: Array<String>,
        @Query("market") market: Array<String>,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
    ): ArtistAlbumsNetwork
}