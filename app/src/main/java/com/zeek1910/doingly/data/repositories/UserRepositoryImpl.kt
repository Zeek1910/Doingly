package com.zeek1910.doingly.data.repositories

import com.google.firebase.firestore.FirebaseFirestore
import com.zeek1910.doingly.domain.model.User
import com.zeek1910.doingly.domain.repositories.UserRepository
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : UserRepository {

    override suspend fun createUser(user: User): Boolean {
        firestore.collection(USERS_COLLECTION_NAME).document(user.uid!!).set(user).await()
        return true
    }

    override suspend fun getUserByUid(uid: String): User? {
        return firestore.collection(USERS_COLLECTION_NAME).document(uid).get().await()
            .toObject(User::class.java)
    }

    companion object {
        private const val USERS_COLLECTION_NAME = "users"
    }

}