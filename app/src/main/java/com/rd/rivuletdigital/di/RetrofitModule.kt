package com.rd.rivuletdigital.di


import com.rd.rivuletdigital.repository.OAuthInterceptor
import com.rd.rivuletdigital.repository.RetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object  RetrofitModule {


        const val BaseURL="https://marcom3-dam.whitelabeliq.net/"


    @Provides
    @Singleton
    fun provideRetrofitInstance():Retrofit{

        return Retrofit.Builder().baseUrl(BaseURL).addConverterFactory(GsonConverterFactory.create()).build()

    }

    @Provides
    @Singleton
    fun provideRetrofitService(retrofit: Retrofit): RetrofitService {

        return retrofit.create(RetrofitService::class.java)

    }


}