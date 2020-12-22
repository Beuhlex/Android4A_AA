package com.example.android4a_aurelienandrieux.domain.usecase

import com.example.android4a_aurelienandrieux.data.repository.UserRepository
import com.example.android4a_aurelienandrieux.domain.entity.User

class GetUserUseCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke(email: String): User {
        return userRepository.getUser(email)
    }
}
