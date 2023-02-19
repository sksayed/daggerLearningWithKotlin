package com.example.daggerlearning.di.module

import com.example.daggerlearning.App
import com.example.daggerlearning.BuildConfig
import com.example.daggerlearning.data.pkg.api.ApiHelper
import com.example.daggerlearning.data.pkg.api.ApiHelperImpl
import com.example.daggerlearning.data.pkg.api.ApiService
import com.example.daggerlearning.data.pkg.model.BengaliUser
import com.example.daggerlearning.data.pkg.model.EnglishUser
import com.example.daggerlearning.di.module.ApplicationModule.Companion.URL_MOCKAPI
import com.example.daggerlearning.utils.CoroutineDispatcherProvider
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {
//    @Provides
//    @Named(URL_MOCKAPI)
//    fun provideBaseURL(): String = App.BASE_URL

    @Provides
    //@Named(URL_TYPECODE)
    fun provideURL():String = App.BASE_URL_TYPECODE

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else {
        OkHttpClient.Builder()
            .build()

    }

    @Provides
    @Singleton
    fun provideRetrofit(BASE_URL: String, okHttpClient: OkHttpClient , moshi: Moshi): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    @Provides
    @Singleton
    fun provideApiService (retrofit: Retrofit):ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideApiHelper (apiHelperImpl: ApiHelperImpl):ApiHelper = apiHelperImpl

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    fun provideBengaliUser (englighUser : EnglishUser):BengaliUser {
        return  BengaliUser(englighUser)
    }

    companion object {
        const val URL_TYPECODE = "ULR_TYPECODE"
        const val URL_MOCKAPI = "ULR_MOCKAPI"
    }

    @Provides
    fun provideCoroutineDispatcherProvider()= CoroutineDispatcherProvider()


}