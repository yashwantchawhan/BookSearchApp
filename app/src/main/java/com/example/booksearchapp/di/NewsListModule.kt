package com.example.booksearchapp.di

import com.example.booksearchapp.api.BookApi
import com.example.booksearchapp.newslist.*
import dagger.Module
import dagger.Provides

@Module
class NewsListModule {

    @Provides
    fun newsListViewModel(booksListRepository: BooksListRepository,
                          extractBookDisplayUseCase: ExtractBookDisplayUseCase) =
            BooksListViewModel(booksListRepository, extractBookDisplayUseCase)

    @Provides
    fun booksListRepository(bookApi: BookApi):
            BooksListRepository = BooksListRepositoryImpl(bookApi)

    @Provides
    fun extractBookDisplayUseCase(): ExtractBookDisplayUseCase = ExtractBookDisplayUseCaseImpl()
}