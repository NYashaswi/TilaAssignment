package com.tila.halloffame.network

import com.tila.halloffame.data.CharacterResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface NetworkApi {
    @GET("/v1/public/characters")
    fun getCharacterList() : Call<CharacterResponse>
}