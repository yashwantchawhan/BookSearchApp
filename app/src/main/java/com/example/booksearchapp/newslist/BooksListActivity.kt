package com.example.booksearchapp.newslist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.booksearchapp.application.BookSearchApplication
import com.example.booksearchapp.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class BooksListActivity : AppCompatActivity() {

    @Inject
    lateinit var booksListViewModel: BooksListViewModel
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as BookSearchApplication).appComponent?.inject(this)
        compositeDisposable.add(booksListViewModel.getBooks(query = "the+lord+of+the+rings")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy {
                    Log.d("Search Book list", "" + it[2].title + it[2].author + it[2].coverUrl)
                })

    }


    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}
