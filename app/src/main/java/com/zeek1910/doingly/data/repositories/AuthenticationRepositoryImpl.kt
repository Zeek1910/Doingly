package com.zeek1910.doingly.data.repositories

import com.google.firebase.auth.FirebaseAuth
import com.zeek1910.doingly.domain.repositories.AuthenticationRepository
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : AuthenticationRepository {

    override suspend fun isSignIn() = firebaseAuth.currentUser != null

    override suspend fun signIn(email: String, password: String): String? {
        return firebaseAuth.signInWithEmailAndPassword(email, password).await().user?.uid
    }

    override suspend fun signUp(email: String, password: String): String? {
        return firebaseAuth.createUserWithEmailAndPassword(email, password).await().user?.uid
    }

    override suspend fun signOut() {
        firebaseAuth.signOut()
    }
}