package com.example.android4a_aurelienandrieux.presentation.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android4a_aurelienandrieux.domain.entity.User
import com.example.android4a_aurelienandrieux.domain.usecase.CreateUserUseCase
import com.example.android4a_aurelienandrieux.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    val loginLiveData : MutableLiveData<LoginStatus> = MutableLiveData()

    fun onClickedLogin(username: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = getUserUseCase.invoke(username, password)
            val loginStatus = if(user != null){
                LoginSuccess(user.username)
            } else {
                LoginError
            }
            withContext(Dispatchers.Main) {
                loginLiveData.value = loginStatus
            }
        }
    }

    fun onClickedCreateAccount(username: String, password: String){
        viewModelScope.launch(Dispatchers.IO) {
            val user = getUserUseCase.invoke(username, password)
            val test = "abort"
            val createAccountStatus = if(username == ""){
                CreateAccountNullUsername
            }else if(password == ""){
                CreateAccountNullPassword
            }else if(user != null){
                CreateAccountError
            } else {
                CreateAccountSuccess(username)
            }
            if(createAccountStatus == CreateAccountSuccess(username)){
                createUserUseCase.invoke(User(username, password))
            }
            withContext(Dispatchers.Main) {
                loginLiveData.value = createAccountStatus
            }
        }
    }
}