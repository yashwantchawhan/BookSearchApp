package com.example.booksearchapp.di

import com.example.booksearchapp.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}