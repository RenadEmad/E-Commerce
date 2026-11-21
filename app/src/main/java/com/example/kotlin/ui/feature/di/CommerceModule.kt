package com.example.kotlin.ui.feature.di

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

}