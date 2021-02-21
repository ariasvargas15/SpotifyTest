package com.bsav157.spotifytest.presentation.main

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bsav157.spotifytest.R
import com.bsav157.spotifytest.databinding.ActivityMainBinding
import com.bsav157.spotifytest.domain.Search
import com.bsav157.spotifytest.presentation.main.IMain
import com.spotify.sdk.android.auth.AuthorizationClient
import com.spotify.sdk.android.auth.AuthorizationRequest
import com.spotify.sdk.android.auth.AuthorizationResponse
import com.spotify.sdk.android.auth.LoginActivity.REQUEST_CODE
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), IMain.View {

    private lateinit var editor: SharedPreferences.Editor
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var clientId : String
    private lateinit var redirectUri : String
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var presenter: IMain.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        sharedPreferences = getSharedPreferences("SPOTIFY", 0)
        clientId = getString(R.string.client_id)
        redirectUri = getString(R.string.redirect_uri)
    }

    fun login(view: View) {
        openLoginActivity()
    }

    private fun openLoginActivity() {
        val builder = AuthorizationRequest.Builder(clientId, AuthorizationResponse.Type.TOKEN, redirectUri)
        builder.setScopes(arrayOf("streaming"))
        val request = builder.build()
        AuthorizationClient.openLoginActivity(this, REQUEST_CODE, request)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        if (requestCode == REQUEST_CODE) {
            val response = AuthorizationClient.getResponse(resultCode, intent)
            when (response.type) {
                AuthorizationResponse.Type.TOKEN -> {
                    editor = getSharedPreferences("SPOTIFY", 0).edit()
                    editor.putString("token", response.accessToken)
                    editor.apply()
                    Log.e("token", response.accessToken)
                    presenter.getSearch("Muse")
                }
                AuthorizationResponse.Type.ERROR -> {
                    //TODO
                }
                else -> {
                }
            }
        }
    }

    override fun showSearch(search: Search) {
        //TODO
    }



}
