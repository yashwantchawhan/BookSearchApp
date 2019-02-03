package com.example.booksearchapp.di

import com.example.booksearchapp.BASE_URL
import com.example.booksearchapp.api.BookApi
import dagger.Module
import dagger.Provides
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    @Named(NAME_BASE_URL)
    fun provideBaseUrl(): String {
        return BASE_URL
    }

    @Provides
    @Singleton
    fun provideGsonConverter(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideRetrofit(converter: Converter.Factory, @Named(NAME_BASE_URL) baseUrl: String): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converter)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun provideUsdaApi(retrofit: Retrofit): BookApi {
        return retrofit.create(BookApi::class.java)
    }
}

private const val NAME_BASE_URL = "NAME_BASE_URL"
