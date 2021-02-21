package com.bsav157.spotifytest.framework.network

import com.bsav157.spotifytest.framework.network.models.SearchNetwork
import retrofit2.http.GET
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
}