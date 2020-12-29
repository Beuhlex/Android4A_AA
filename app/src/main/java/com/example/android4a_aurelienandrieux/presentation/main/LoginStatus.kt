package com.example.android4a_aurelienandrieux.presentation.main

sealed class LoginStatus

data class LoginSuccess(val username: String) : LoginStatus()

object LoginError : LoginStatus()

data class CreateAccountSuccess(val username: String) : LoginStatus()

object CreateAccountError : LoginStatus()

object CreateAccountNullUsername: LoginStatus()

object CreateAccountNullPassword: LoginStatus()