package com.bsav157.spotifytest.usecases

import com.bsav157.spotifytest.data.repositories.SpotifyRepository
import com.bsav157.spotifytest.domain.ArtistAlbums
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
class GetAlbumsByArtistTest {
    @Mock
    private lateinit var spotifyRepository: SpotifyRepository

    @InjectMocks
    private lateinit var getAlbumsByArtist: GetAlbumsByArtist

    @Test
    fun invokeTest() = runBlocking {
        val idArtist = "BdgEacscXasd"
        val groups = arrayOf("album")
        val params = Mockito.mock(SearchParams::class.java)
        val artistAlbums = Mockito.mock(ArtistAlbums::class.java)

        Mockito.`when`(spotifyRepository.getAlbumsByArtist(idArtist, groups, params))
            .thenReturn(artistAlbums)

        val search2 = getAlbumsByArtist.invoke(idArtist, groups, params)

        Assert.assertNotNull(search2)
        Assert.assertEquals(artistAlbums, search2)
    }
}