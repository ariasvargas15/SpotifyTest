package com.bsav157.spotifytest.presentation.main

import com.bsav157.spotifytest.domain.Search

interface IMain {
    interface View {
        fun showSearch(search: Search)
    }

    interface Presenter {
        fun getSearch(query: String)
    }
}