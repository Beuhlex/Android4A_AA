package com.example.android4a_aurelienandrieux.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android4a_aurelienandrieux.domain.entity.User
import com.example.android4a_aurelienandrieux.domain.usecase.CreateUserUseCase
import com.example.android4a_aurelienandrieux.domain.usecase.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    val counter : MutableLiveData<Int> = MutableLiveData()

    init{
        counter.value = 0
    }

    fun onClickedIncrement(emailUser: String) {
        viewModelScope.launch(Dispatchers.IO) {
            createUserUseCase.invoke(User("test"))
            val user = getUserUseCase.invoke("test")
            val debug = "debug"
        }
    }
}