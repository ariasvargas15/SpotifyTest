package com.bsav157.spotifytest.presentation.search

import com.bsav157.spotifytest.domain.Search

interface ISearch {
    interface View {
        fun showSearch(search: Search)
    }

    interface Presenter {
        fun getSearch(query: String)
    }
}