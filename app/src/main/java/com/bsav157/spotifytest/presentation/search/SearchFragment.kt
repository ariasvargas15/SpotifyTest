package com.bsav157.spotifytest.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.ContentLoadingProgressBar
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.bsav157.spotifytest.R
import com.bsav157.spotifytest.databinding.FragmentSearchBinding
import com.bsav157.spotifytest.domain.Search
import com.bsav157.spotifytest.presentation.commons.hideKeyboard
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SearchFragment : Fragment(), ISearch.View {

    @Inject
    lateinit var presenter: SearchPresenter

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val view = binding.root
        navController = findNavController()
        onClickSearch()
        binding.progress.isActivated = true
        binding.progress.hide()
        return view
    }

    private fun onClickSearch() {
        binding.buttonSearch.setOnClickListener {
            hideKeyboard()

            binding.progress.show()
            val query = binding.inputSearch.text.toString()
            if (query.isNotEmpty()) {
                presenter.getSearch(query)
            } else {
                Snackbar.make(binding.root, "The field cannot be empty", Snackbar.LENGTH_LONG)
                    .show()
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun showSearch(search: Search) {
        binding.progress.hide()
        if (search.artistSearch.artists.isNotEmpty()){
            val bundle = Bundle()
            bundle.putSerializable("search", search)
            navController.navigate(R.id.action_searchFragment_to_artistFragment, bundle)
        } else {
            Snackbar.make(binding.root, "There are no results for your search", Snackbar.LENGTH_LONG)
                .show()
        }
    }
}