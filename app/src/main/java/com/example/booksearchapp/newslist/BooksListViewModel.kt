package com.example.booksearchapp.newslist

import com.example.booksearchapp.model.BookDisplay
import io.reactivex.Single


class BooksListViewModel(private val booksListRepository: BooksListRepository,
                         private val extractBookDisplayUseCase: ExtractBookDisplayUseCase) {

    fun getBooks(query: String) : Single<List<BookDisplay>> {
       return extractBookDisplayUseCase.getBookDisplay(booksListRepository.getBooks(query))
    }
}