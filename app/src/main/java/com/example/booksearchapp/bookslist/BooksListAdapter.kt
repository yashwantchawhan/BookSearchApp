package com.example.booksearchapp.bookslist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.android.databinding.library.baseAdapters.BR
import com.example.booksearchapp.databinding.ListItemBookBinding
import com.example.booksearchapp.model.BookDisplay
import com.example.booksearchapp.utility.BindableAdapter

class BooksListAdapter : RecyclerView.Adapter<BooksListAdapter.BooksViewHolder>(), BindableAdapter<List<BookDisplay>> {

    val listOfBooks = arrayListOf<BookDisplay>()

    override fun setData(items: List<BookDisplay>) {
        listOfBooks.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = ListItemBookBinding.inflate(layoutInflater, parent, false)
        return BooksViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return listOfBooks.size
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
        val item = listOfBooks.get(position)
        holder.bind(item)
    }

    inner class BooksViewHolder(private val binding: ListItemBookBinding) : RecyclerView.ViewHolder(binding.getRoot()) {

        fun bind(bookDisplay: BookDisplay) {
            binding.setVariable(BR.book, bookDisplay);
            binding.executePendingBindings();
        }

    }
}