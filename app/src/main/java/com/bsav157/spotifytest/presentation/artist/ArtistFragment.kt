package com.bsav157.spotifytest.presentation.artist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.bsav157.spotifytest.R
import com.bsav157.spotifytest.databinding.FragmentArtistBinding
import com.bsav157.spotifytest.domain.Album
import com.bsav157.spotifytest.domain.Artist
import com.bsav157.spotifytest.domain.ArtistAlbums
import com.bsav157.spotifytest.domain.Search
import com.bsav157.spotifytest.presentation.commons.GlideApp
import com.bsav157.spotifytest.presentation.commons.formatNumber
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ArtistFragment : Fragment(), IArtist.View, OnClickAlbum {

    @Inject
    lateinit var presenter: IArtist.Presenter

    private var search: Search? = null
    private val key = "search"
    private lateinit var artist: Artist
    private lateinit var albumAdapter: AlbumAdapter

    private var _binding: FragmentArtistBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            search = it.getSerializable(key) as Search
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentArtistBinding.inflate(inflater, container, false)
        val view = binding.root
        navController = findNavController()
        fillData()
        presenter.getAlbums(artist.id)
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun fillData() {
        search?.let {
            artist = it.artistSearch.artists[0]

            GlideApp.with(this)
                .load(artist.images[0].url)
                .into(binding.imageArtist)

            binding.textArtistName.text = artist.name

            val followers = formatNumber(artist.followers.total)
            binding.textAmountFollowers.text = followers

            val popularity = "${artist.popularity} of 100"
            binding.textNumberPopularity.text = popularity
        }
    }

    override fun showAlbums(artistAlbums: ArtistAlbums) {
        albumAdapter = AlbumAdapter()
        binding.recyclerAlbums.adapter = albumAdapter
        albumAdapter.albums = artistAlbums.albums
        albumAdapter.onClickAlbum = this
    }

    override fun onClick(album: Album) {
        val bundle = Bundle()
        bundle.putSerializable("album", album)
        navController.navigate(R.id.action_artistFragment_to_albumFragment, bundle)
    }


}