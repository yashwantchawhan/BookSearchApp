package com.example.booksearchapp.bookslist

import com.example.booksearchapp.model.Book
import com.example.booksearchapp.model.BookDisplay
import io.reactivex.Observable
import io.reactivex.Single

interface ExtractBookDisplayUseCase {
    fun getBookDisplay(listOfDocs: Observable<Book>): Single<List<BookDisplay>>
}

class ExtractBookDisplayUseCaseImpl : ExtractBookDisplayUseCase {
    override fun getBookDisplay(listOfDocs: Observable<Book>): Single<List<BookDisplay>> {
        return listOfDocs
                .map { docs -> docs.docs }
                .flatMapIterable { doc -> doc }
                .map { bookDisplay -> BookDisplay(bookDisplay.titleSuggest, bookDisplay.authorName, bookDisplay.coverUrl) }
                .toList()
    }
}