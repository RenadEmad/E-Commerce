package com.example.kotlin.ui.feature.di

import com.example.kotlin.ui.feature.auth.data.data_source.remote.AuthRemoteDataSource
import com.example.kotlin.ui.feature.auth.data.data_source.remote.AuthRemoteDataSourceImpl
import com.example.kotlin.ui.feature.auth.data.repo.AuthRepo
import com.example.kotlin.ui.feature.auth.domain.repo.AuthRepoImpl
import com.example.kotlin.ui.feature.commerce.data.data_sources.local.AuthLocalDataSource
import com.example.kotlin.ui.feature.commerce.data.data_sources.local.AuthLocalDataSourceImpl
import com.example.kotlin.ui.feature.commerce.data.data_sources.remote.home.HomeRemoteDataSource
import com.example.kotlin.ui.feature.commerce.data.data_sources.remote.home.HomeRemoteDataSourceImpl
import com.example.kotlin.ui.feature.commerce.data.repo.HomeRepoImp
import com.example.kotlin.ui.feature.commerce.domain.repo.home.HomeRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CommerceModule{
    @Binds
    abstract fun bindHomeRepo(
        homeRepoImp:HomeRepoImp
    ): HomeRepo

    @Binds
    @Singleton
    abstract fun bindHomeRepoDataSource(
        homeRemoteDataSourceImpl: HomeRemoteDataSourceImpl
    ): HomeRemoteDataSource


    @Binds
    abstract  fun  bindAuthRepo(
        authRepoImpl: AuthRepoImpl
    ): AuthRepo


    @Binds
    abstract fun bindAuthRemoteDataSource(
        authRemoteDataSourceImpl: AuthRemoteDataSourceImpl
    ): AuthRemoteDataSource


    @Binds
abstract fun bindAuthLocalDataSource(
    authLocalDataSourceImpl: AuthLocalDataSourceImpl
) : AuthLocalDataSource

}