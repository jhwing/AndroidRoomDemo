package com.stark.room.demo.main

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.stark.room.demo.db.bean.Task

object MainBindings {

    @JvmStatic
    @BindingAdapter("mainListItems")
    fun setMainListItems(recyclerView: RecyclerView, items: MutableList<Task>) {
        with(recyclerView.adapter as MainListAdapter) {
            this.items = items
            notifyDataSetChanged()
        }
    }
}