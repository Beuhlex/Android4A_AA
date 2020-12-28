package com.example.android4a_aurelienandrieux.presentation.list

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android4a_aurelienandrieux.data.local.models.RestZeldaGamesResponse
import com.example.android4a_aurelienandrieux.data.local.models.ZeldaGames
import com.example.android4a_aurelienandrieux.data.remote.LozApi
import com.example.android4a_aurelienandrieux.injection.Constants.BASE_URL
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ListViewModel(

): ViewModel(){

    val loginLiveData : MutableLiveData<getApiStatus> = MutableLiveData()

    fun makeApiCall(){
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val lozApi: LozApi = retrofit.create(LozApi::class.java)

        val call: Call<RestZeldaGamesResponse> = lozApi.getZeldaGamesResponse()
        call.enqueue(object : Callback<RestZeldaGamesResponse> {
            override fun onResponse(call: Call<RestZeldaGamesResponse?>, response: Response<RestZeldaGamesResponse?>) {
                if (response.isSuccessful && response.body() != null) {
                    val zeldaGamesList: List<ZeldaGames> = response.body()!!.results!!
                    loginLiveData.value = getApiSuccess(zeldaGamesList)
                } else {
                    loginLiveData.value = getApiFailure
                }
            }

            override fun onFailure(call: Call<RestZeldaGamesResponse?>, t: Throwable) {
                loginLiveData.value = getApiError
            }
        })
    }
}