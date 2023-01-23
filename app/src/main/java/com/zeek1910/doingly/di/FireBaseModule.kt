package com.zeek1910.doingly.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object FireBaseModule {

    @Provides
    fun provideFirebaseAuth() = FirebaseAuth.getInstance()

    @Provides
    fun provideFirebaseFirestore() = FirebaseFirestore.getInstance()
}