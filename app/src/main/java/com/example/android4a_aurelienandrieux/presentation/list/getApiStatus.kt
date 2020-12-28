package com.example.android4a_aurelienandrieux.presentation.list

import com.example.android4a_aurelienandrieux.data.local.models.ZeldaGames

sealed class getApiStatus

data class getApiSuccess(val lozGamesList: List<ZeldaGames>) : getApiStatus()

object getApiError : getApiStatus()

object getApiFailure : getApiStatus()