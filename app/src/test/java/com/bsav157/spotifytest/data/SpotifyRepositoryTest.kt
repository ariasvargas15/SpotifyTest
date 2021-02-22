package com.bsav157.spotifytest.data

import com.bsav157.spotifytest.data.repositories.SpotifyRepository
import com.bsav157.spotifytest.data.sources.RemoteSource
import com.bsav157.spotifytest.domain.ArtistAlbums
import com.bsav157.spotifytest.domain.Search
import com.bsav157.spotifytest.domain.SearchParams
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.robolectric.annotation.Config

@RunWith(MockitoJUnitRunner::class)
@Config(manifest = Config.NONE)
class SpotifyRepositoryTest {

    @Mock
    private lateinit var remoteDataSource: RemoteSource

    @InjectMocks
    private lateinit var spotifyRepository: SpotifyRepository

    @Test
    fun doSearchTest() = runBlocking {
        val query = "Sia"
        val type = arrayOf("artist")
        val params = Mockito.mock(SearchParams::class.java)
        val search = Mockito.mock(Search::class.java)

        Mockito.`when`(remoteDataSource.doSearch(query, type, params)).thenReturn(search)

        val search2 = spotifyRepository.doSearch(query, type, params)

        Assert.assertNotNull(search2)
        Assert.assertEquals(search, search2)
    }

    @Test
    fun getAlbumsByArtistTest() = runBlocking {
        val idArtist = "BdgEacscXasd"
        val groups = arrayOf("album")
        val params = Mockito.mock(SearchParams::class.java)
        val artistAlbums = Mockito.mock(ArtistAlbums::class.java)

        Mockito.`when`(remoteDataSource.getAlbumsByArtist(idArtist, groups, params))
            .thenReturn(artistAlbums)

        val search2 = spotifyRepository.getAlbumsByArtist(idArtist, groups, params)

        Assert.assertNotNull(search2)
        Assert.assertEquals(artistAlbums, search2)

    }
}