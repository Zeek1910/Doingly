package com.zeek1910.doingly.domain.repositories

interface AuthenticationRepository {
    suspend fun isSignIn(): Boolean
    suspend fun signIn(email: String, password: String): String?
    suspend fun signUp(email: String, password: String): String?
    suspend fun signOut()
}