package com.example.android4a_aurelienandrieux.presentation.main

sealed class LoginStatus

data class LoginSuccess(val email: String) : LoginStatus()

object LoginError : LoginStatus()