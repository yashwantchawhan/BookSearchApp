package com.example.booksearchapp.bookslist

import com.example.booksearchapp.api.BookApi
import com.example.booksearchapp.model.Book
import io.reactivex.Observable

interface BooksListRepository {
    fun getBooks(query: String): Observable<Book>
}

class BooksListRepositoryImpl(private val bookApi: BookApi) : BooksListRepository {
    override fun getBooks(query: String): Observable<Book> {
        return bookApi.getBooks(query)
    }
}