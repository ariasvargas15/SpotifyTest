package com.bsav157.spotifytest.presentation.artist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.bsav157.spotifytest.databinding.FragmentArtistBinding
import com.bsav157.spotifytest.domain.Followers
import com.bsav157.spotifytest.domain.Search
import com.bsav157.spotifytest.presentation.commons.GlideApp
import com.bsav157.spotifytest.presentation.commons.formatNumber
import dagger.hilt.android.AndroidEntryPoint
import java.text.NumberFormat
import java.util.*

@AndroidEntryPoint
class ArtistFragment : Fragment() {

    private var search: Search? = null
    private val key = "search"

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
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun fillData(){
        search?.let {
            GlideApp.with(this)
                .load(it.artistSearch.artists[0].images[0].url)
                .into(binding.imageArtist)

            val followers = formatNumber(it.artistSearch.artists[0].followers.total)
            binding.textAmountFollowers.text = followers

            val popularity = "${it.artistSearch.artists[0].popularity} of 100"
            binding.textNumberPopularity.text = popularity
        }
    }


}