package com.example.android4a_aurelienandrieux.presentation.list

sealed class getApiStatus

object getApiSuccess : getApiStatus()

object getApiError : getApiStatus()

object getApiFailure : getApiStatus()