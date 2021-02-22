package com.bsav157.spotifytest.presentation.artist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bsav157.spotifytest.R
import com.bsav157.spotifytest.databinding.ItemAlbumBinding
import com.bsav157.spotifytest.domain.Album
import com.bsav157.spotifytest.presentation.commons.GlideApp
import java.util.*
import kotlin.collections.ArrayList

class AlbumAdapter : RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    var albums: List<Album> = ArrayList()
    lateinit var onClickAlbum: OnClickAlbum

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_album, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val album = albums[position]
        holder.bind(album)
        holder.itemView.setOnClickListener{
            onClickAlbum.onClick(album)
        }
    }

    override fun getItemCount(): Int = albums.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ItemAlbumBinding.bind(view)

        fun bind(album: Album) {
            GlideApp.with(this.itemView)
                .load(album.images[0].url)
                .into(binding.imageAlbum)
            binding.textAlbumName.text = album.name

            if (album.markets.size <= 5) {
                var countries = "Available only in "
                album.markets.forEachIndexed { i, it ->
                    val locale = Locale("en", it).displayCountry
                    countries += when {
                        album.markets.size == 1 -> "$locale."
                        i == album.markets.size - 1 -> "and $locale."
                        i == album.markets.size - 2 -> "$locale "
                        else -> "$locale, "
                    }
                }
                binding.textAvailable.text = countries
            } else {
                binding.textAvailable.visibility = View.GONE
            }
        }
    }
}