package com.example.kotlin.ui.feature.network.api

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn( SingletonComponent::class)
class NetworkModule{

    @Provides
    @Singleton
    fun provideOkHttpClient():OkHttpClient{

        val interceptor=HttpLoggingInterceptor{
//           message->  Log.e("Api",message)

        }.apply {

            level = HttpLoggingInterceptor.Level.BODY
        }
        val client= OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
        return  client
    }


    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit{
    val retrofit=  Retrofit.Builder()
          .baseUrl(ApiEndPoints.BASEURL)
          .addConverterFactory(GsonConverterFactory.create())
          .client(okHttpClient)
          .build()
       return retrofit
    }

    @Provides
    @Singleton
    fun provideApiServices(retrofit: Retrofit) :ApiServices{
        return  retrofit.create(ApiServices::class.java)
    }
}
