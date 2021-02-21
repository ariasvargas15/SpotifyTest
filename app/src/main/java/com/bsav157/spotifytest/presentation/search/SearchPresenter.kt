package com.bsav157.spotifytest.presentation.search

import com.bsav157.spotifytest.domain.SearchParams
import com.bsav157.spotifytest.presentation.commons.ScopeImpl
import com.bsav157.spotifytest.usecases.DoSearch
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchPresenter @Inject constructor(
    private val doSearch: DoSearch,
    private val view: ISearch.View
) : ISearch.Presenter, ScopeImpl() {

    override fun getSearch(query: String) {
        launch {
            val search = doSearch.invoke(query, arrayOf("artist"), SearchParams(arrayOf(), 20, 0))
            view.showSearch(search)
        }
    }
}
