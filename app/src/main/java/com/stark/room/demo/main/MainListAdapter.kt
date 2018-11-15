package com.stark.room.demo.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.stark.room.demo.databinding.TaskListItemBinding
import com.stark.room.demo.db.bean.Task

class MainListAdapter(context: Context) : RecyclerView.Adapter<MainListAdapter.MainListViewHolder>() {

    private var layoutInflater = LayoutInflater.from(context)
    var items: MutableList<Task>? = null
    var onItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListViewHolder {
        var binding = TaskListItemBinding.inflate(layoutInflater, parent, false)
        binding.listener = onItemClickListener
        return MainListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return if (items == null) 0 else items!!.size
    }

    override fun onBindViewHolder(holder: MainListViewHolder, position: Int) {
        holder.bind(items!![position])
    }

    interface OnItemClickListener {
        fun onItemClick(task: Task)
    }

    class MainListViewHolder(var mBinding: TaskListItemBinding) : RecyclerView.ViewHolder(mBinding.root) {

        fun bind(item: Task) {
            mBinding.item = item
        }
    }
}