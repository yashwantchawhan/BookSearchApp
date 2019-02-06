package com.example.booksearchapp.utility

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.bumptech.glide.Glide


@BindingAdapter("bind:imageUrl")
fun setImageUrl(view: ImageView, url: String) {
    Glide.with(view.context).load(url).into(view)
}

@BindingAdapter("data")
fun <T> setRecyclerViewProperties(recyclerView: RecyclerView, data: T) {
    if (recyclerView.adapter is BindableAdapter<*> && data!=null) {
        (recyclerView.adapter as BindableAdapter<T>).setData(data)
    }
}