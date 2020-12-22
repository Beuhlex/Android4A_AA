package com.example.android4a_aurelienandrieux.domain.usecase

import com.example.android4a_aurelienandrieux.data.repository.UserRepository
import com.example.android4a_aurelienandrieux.domain.entity.User

class CreateUserUseCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke(user: User){
        userRepository.createUser(user)
    }
}