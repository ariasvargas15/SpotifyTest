package com.bsav157.spotifytest.usecases

import com.bsav157.spotifytest.data.repositories.SpotifyRepository
import com.bsav157.spotifytest.domain.Search
import com.bsav157.spotifytest.domain.SearchParams
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner
import org.robolectric.annotation.Config

@RunWith(MockitoJUnitRunner::class)
@Config(manifest = Config.NONE)
class DoSearchTest {

    @Mock
    private lateinit var spotifyRepository: SpotifyRepository

    @InjectMocks
    private lateinit var doSearch: DoSearch

     @Test
     fun invokeTest() = runBlocking {
         val query = "Sia"
         val type = arrayOf("artist")
         val params = mock(SearchParams::class.java)
         val search = mock(Search::class.java)

         Mockito.`when`(spotifyRepository.doSearch(query, type, params)).thenReturn(search)

         val search2 = doSearch.invoke(query, type, params)

         Assert.assertNotNull(search2)
         Assert.assertEquals(search, search2)
     }
}