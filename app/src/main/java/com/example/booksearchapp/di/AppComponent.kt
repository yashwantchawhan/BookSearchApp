package com.example.booksearchapp.di

import com.example.booksearchapp.newslist.BooksListActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, NewsListModule::class])
interface AppComponent {
    fun inject(booksListActivity: BooksListActivity)
}