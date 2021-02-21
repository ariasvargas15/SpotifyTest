package com.bsav157.spotifytest.framework.di

import android.app.Application
import com.bsav157.spotifytest.network.ApiService
import com.bsav157.spotifytest.network.OAuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    private val baseUrl = "https://api.spotify.com/v1/"

    @Provides
    fun provideHttpClient(interceptor: OAuthInterceptor): OkHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(interceptor)
        .build()


    @Provides
    @Singleton
    fun provideRetrofit(httpClient: OkHttpClient): ApiService =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .run {
                create(ApiService::class.java)
            }

    @Provides
    fun providesTokenInterceptor(app: Application): OAuthInterceptor {
        val token = app.getSharedPreferences("SPOTIFY", 0).getString("token", "")
        return OAuthInterceptor("Bearer", token ?: "")
    }


}

