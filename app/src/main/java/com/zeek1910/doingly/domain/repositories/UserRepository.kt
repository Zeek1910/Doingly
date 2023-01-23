package com.zeek1910.doingly.domain.repositories

import com.zeek1910.doingly.domain.model.User

interface UserRepository {
    suspend fun createUser(user: User): Boolean
    suspend fun getUserByUid(uid: String): User?
}