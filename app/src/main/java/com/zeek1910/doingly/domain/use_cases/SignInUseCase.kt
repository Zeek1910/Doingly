package com.zeek1910.doingly.domain.use_cases

import com.zeek1910.doingly.domain.exceptions.UserNotFoundException
import com.zeek1910.doingly.domain.model.User
import com.zeek1910.doingly.domain.repositories.AuthenticationRepository
import com.zeek1910.doingly.domain.repositories.UserRepository
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val authenticationRepository: AuthenticationRepository,
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(email: String, password: String): User? {
        val uid = authenticationRepository.signIn(email, password)
        if (uid != null) {
            return userRepository.getUserByUid(uid)
        } else {
            throw UserNotFoundException()
        }
    }
}