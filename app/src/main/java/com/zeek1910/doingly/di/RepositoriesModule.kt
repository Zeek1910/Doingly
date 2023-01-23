package com.zeek1910.doingly.di

import com.zeek1910.doingly.data.repositories.AuthenticationRepositoryImpl
import com.zeek1910.doingly.data.repositories.UserRepositoryImpl
import com.zeek1910.doingly.domain.repositories.AuthenticationRepository
import com.zeek1910.doingly.domain.repositories.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModule {

    @Binds
    fun bindAuthenticationRepository(
        authenticationRepositoryImpl: AuthenticationRepositoryImpl
    ): AuthenticationRepository

    @Binds
    fun bindUserRepository(userRepositoryImpl: UserRepositoryImpl): UserRepository
}