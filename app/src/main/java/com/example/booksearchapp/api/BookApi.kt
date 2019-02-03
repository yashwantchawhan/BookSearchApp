package com.example.booksearchapp.api

import com.example.booksearchapp.model.Book
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface BookApi {
    @GET("search.json")
    fun getBooks(@Query("q") query: String) : Observable<Book>
}