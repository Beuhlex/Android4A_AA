package com.example.android4a_aurelienandrieux.data.remote

import com.example.android4a_aurelienandrieux.data.local.models.RestZeldaGamesResponse
import retrofit2.Call
import retrofit2.http.GET

interface LozApi {
    @GET("fakeZeldaGamesAPI.json")
    fun getZeldaGamesResponse(): Call<RestZeldaGamesResponse>
}