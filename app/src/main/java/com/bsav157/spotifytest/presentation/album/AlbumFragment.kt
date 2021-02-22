package com.bsav157.spotifytest.presentation.album

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bsav157.spotifytest.R
import com.bsav157.spotifytest.databinding.FragmentAlbumBinding
import com.bsav157.spotifytest.databinding.FragmentArtistBinding
import com.bsav157.spotifytest.databinding.FragmentSearchBinding
import com.bsav157.spotifytest.domain.Album
import com.bsav157.spotifytest.presentation.commons.GlideApp
import com.bumptech.glide.Glide


class AlbumFragment : Fragment() {

    private var album: Album? = null
    private val key = "album"

    private var _binding: FragmentAlbumBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            album = it.getSerializable(key) as Album
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAlbumBinding.inflate(inflater, container, false)
        val view = binding.root
        fillData()
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun fillData() {
        album?.let {
            GlideApp.with(this)
                .load(it.images[0].url)
                .into(binding.imageAlbumDetails)

            binding.buttonOpenLink.setOnClickListener{ _ ->
                openLink(it.url.spotifyUrl)
            }
        }
    }

    private fun openLink(link: String) {
        var url = link
        if (!link.contains("http", true)) {
            url = "http://$link"
        }
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

}