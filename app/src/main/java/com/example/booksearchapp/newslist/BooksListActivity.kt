package com.example.booksearchapp.newslist

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.booksearchapp.R
import com.example.booksearchapp.application.BookSearchApplication
import com.example.booksearchapp.databinding.ActivityMainBinding
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
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        (application as BookSearchApplication).appComponent?.inject(this)

        val bookListAdapter = BooksListAdapter()
        binding.rvBooksList.layoutManager = LinearLayoutManager(this)
        binding.rvBooksList.adapter = bookListAdapter

        compositeDisposable.add(booksListViewModel.getBooks("Oscar Wilde")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy {
                    bookListAdapter.setData(it)
                })

    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}
