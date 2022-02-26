package com.hsb.iconfinder_kotlin.di

import com.hsb.iconfinder_kotlin.common.Constance
import com.hsb.iconfinder_kotlin.data.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton



@InstallIn(SingletonComponent::class)
@Module
object ApiModule {


    @Singleton
    @Provides
    fun provideApiRetrofitServices() : ApiService{

        var okHttpClient = OkHttpClient.Builder().apply {
            addInterceptor(
                Interceptor { chain ->
                    val builder = chain.request().newBuilder()
                    builder.header("Accept", "application/json")
                    builder.header("Authorization", "Bearer X0vjEUN6KRlxbp2DoUkyHeM0VOmxY91rA6BbU5j3Xu6wDodwS0McmilLPBWDUcJ1")
                    return@Interceptor chain.proceed(builder.build())
                }
            )
        }.build()


        return Retrofit.Builder()
            .baseUrl(Constance.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ApiService::class.java)

    }
}