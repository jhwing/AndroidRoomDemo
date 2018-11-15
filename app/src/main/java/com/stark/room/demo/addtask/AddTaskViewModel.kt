package com.stark.room.demo.addtask

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.stark.room.demo.db.TaskDataBase
import com.stark.room.demo.db.bean.Task
import org.jetbrains.anko.doAsync

class AddTaskViewModel(application: Application) : AndroidViewModel(application) {

    var taskDao = TaskDataBase.getDataBase(application)?.getTaskDao()

    var task: Task? = null

    fun save(name: String) {
        var task = Task(0, name = name, date = System.currentTimeMillis())
        doAsync {
            taskDao?.insert(task)
        }
    }

    fun update() {
        doAsync {
            if (task != null) {
                taskDao?.update(task!!)
            }
        }
    }

    fun delete() {
        doAsync {
            if (task != null) {
                taskDao?.delete(task!!)
            }
        }
    }
}