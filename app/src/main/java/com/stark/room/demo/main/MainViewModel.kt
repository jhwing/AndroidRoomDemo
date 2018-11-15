package com.stark.room.demo.main

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableArrayList
import com.stark.room.demo.db.TaskDataBase
import com.stark.room.demo.db.bean.Task
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainViewModel(application: Application) : AndroidViewModel(application) {

    var items = ObservableArrayList<Task>()

    var taskDao = TaskDataBase.getDataBase(application)?.getTaskDao()

    fun load() {
        doAsync {
            val tasks = taskDao?.getAllTasks()
            uiThread {
                tasks?.let { it1 ->
                    items.clear()
                    items.addAll(it1)
                }
            }
        }
    }
}