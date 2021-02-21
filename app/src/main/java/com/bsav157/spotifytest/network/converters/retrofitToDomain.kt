package com.bsav157.spotifytest.network.converters

import com.bsav157.spotifytest.domain.*
import com.bsav157.spotifytest.network.models.*


fun AlbumNetwork.convertToDomain(): Album =
    Album(id, images.map { it.convertToDomain() }, name, totalTracks, uri, markets, url.convertToDomain())

fun ArtistNetwork.convertToDomain(): Artist =
    Artist(id, followers.convertToDomain(), genres, images.map { it.convertToDomain() }, name, popularity, uri)

fun ArtistAlbumsNetwork.convertToDomain(): ArtistAlbums =
    ArtistAlbums(albums.map { it.convertToDomain() }, limit, offset, total, next, previous)

fun ArtistSearchNetwork.convertToDomain(): ArtistSearch =
    ArtistSearch(artists.map { it.convertToDomain() }, limit, offset)

fun ExternalUrlNetwork.convertToDomain(): ExternalUrl =
    ExternalUrl(spotifyUrl)

fun FollowersNetwork.convertToDomain(): Followers =
    Followers(total)

fun ImageNetwork.convertToDomain(): Image =
    Image(height, width, url)

fun SearchNetwork.convertToDomain(): Search =
    Search(artistSearch.convertToDomain())



