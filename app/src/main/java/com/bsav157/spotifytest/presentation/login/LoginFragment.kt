package com.bsav157.spotifytest.presentation.login

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.bsav157.spotifytest.R
import com.bsav157.spotifytest.databinding.FragmentLoginBinding
import com.bsav157.spotifytest.domain.Search
import com.spotify.sdk.android.auth.AuthorizationClient
import com.spotify.sdk.android.auth.AuthorizationRequest
import com.spotify.sdk.android.auth.AuthorizationResponse
import com.spotify.sdk.android.auth.LoginActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var editor: SharedPreferences.Editor
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var clientId : String
    private lateinit var redirectUri : String
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        sharedPreferences = requireActivity().getSharedPreferences("SPOTIFY", 0)
        clientId = getString(R.string.client_id)
        redirectUri = getString(R.string.redirect_uri)
        navController = findNavController()
        onClickLogin()
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onClickLogin() {
        binding.buttonLogin.setOnClickListener {
            openLoginActivity()
        }
    }

    private fun openLoginActivity() {
        val builder = AuthorizationRequest.Builder(clientId, AuthorizationResponse.Type.TOKEN, redirectUri)
        builder.setScopes(arrayOf("streaming"))
        val request = builder.build()
        AuthorizationClient.openLoginActivity(requireActivity(), LoginActivity.REQUEST_CODE, request)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        if (requestCode == LoginActivity.REQUEST_CODE) {
            val response = AuthorizationClient.getResponse(resultCode, intent)
            when (response.type) {
                AuthorizationResponse.Type.TOKEN -> {
                    editor = requireActivity().getSharedPreferences("SPOTIFY", 0).edit()
                    editor.putString("token", response.accessToken)
                    editor.apply()
                    Log.e("token", response.accessToken)
                    navController.navigate(R.id.action_loginFragment_to_searchFragment)
                }
                AuthorizationResponse.Type.ERROR -> {
                }
                else -> {
                }
            }
        }
    }


}