package com.example.androidsecurity.di

import com.example.androidsecurity.data.ApiService
import com.example.androidsecurity.data.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Singleton
    @Provides
    fun provideAuthRepository(
        apiService: ApiService,
    ): AuthRepository {
        return AuthRepository(
            apiService
        )
    }
}