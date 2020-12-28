package com.example.android4a_aurelienandrieux.presentation.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android4a_aurelienandrieux.data.local.models.RestZeldaGamesResponse
import com.example.android4a_aurelienandrieux.data.local.models.ZeldaGames
import com.example.android4a_aurelienandrieux.data.remote.LozApi
import com.example.android4a_aurelienandrieux.presentation.main.LoginStatus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListViewModel(
    private val lozApi: LozApi
): ViewModel(){

    val loginLiveData : MutableLiveData<getApiStatus> = MutableLiveData()

    init {
        val call: Call<RestZeldaGamesResponse> = lozApi.getZeldaGamesResponse()
        call.enqueue(object: Callback<RestZeldaGamesResponse> {
            override fun onFailure(call: Call<RestZeldaGamesResponse>, t: Throwable) {
                loginLiveData.value = getApiError
            }

            override fun onResponse(
                call: Call<RestZeldaGamesResponse>,
                response: Response<RestZeldaGamesResponse>
            ) {
                if (response.isSuccessful() && response.body() != null) {
                    val zeldaGamesList: List<ZeldaGames> = response.body()!!.results!!
                    loginLiveData.value = getApiSuccess
                } else {
                    loginLiveData.value = getApiFailure
                }
            }
        })
    }
}