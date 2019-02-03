package com.example.booksearchapp

import android.app.Application
import com.example.booksearchapp.di.AppComponent
import com.example.booksearchapp.di.AppModule
import com.example.booksearchapp.di.DaggerAppComponent
import com.example.booksearchapp.di.NetworkModule

class BookSearchApplication : Application() {

    var appComponent: AppComponent? = null
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule())
                .build()
    }
}