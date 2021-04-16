package com.tila.halloffame.network

import com.tila.halloffame.util.ApplicationConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {
    private val logging = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)
    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .addInterceptor(NetworkInterceptor())
        .build()


    fun provideRetrofit() : NetworkApi{
        return Retrofit.Builder()
            .baseUrl(ApplicationConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(NetworkApi::class.java)
    }
}