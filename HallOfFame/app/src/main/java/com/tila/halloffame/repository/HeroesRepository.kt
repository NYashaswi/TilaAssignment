package com.tila.halloffame.repository

import com.tila.halloffame.data.CharacterResponse
import com.tila.halloffame.network.NetworkApi
import com.tila.halloffame.network.NetworkModule
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeroesRepository {
    private var api: NetworkApi? = null

    init {
        api = NetworkModule?.provideRetrofit()
    }

    fun getAllHeroes(): CharacterResponse? {
        var res: CharacterResponse? = null
        val call: Call<CharacterResponse>? = api?.getCharacterList()
        call?.enqueue(object : Callback<CharacterResponse> {
            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
                res = null
            }

            override fun onResponse(
                call: Call<CharacterResponse>,
                response: Response<CharacterResponse>
            ) {
                res = response.body()
            }

        })
        return res
    }
}