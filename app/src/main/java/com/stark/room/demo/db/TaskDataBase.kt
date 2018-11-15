package com.stark.room.demo.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.stark.room.demo.db.bean.Task

@Database(entities = [Task::class], version = 1)
abstract class TaskDataBase : RoomDatabase() {

    abstract fun getTaskDao(): TaskDao

    companion object {

        var INSTANCE: TaskDataBase? = null
        fun getDataBase(context: Context): TaskDataBase? {
            if (INSTANCE == null) {
                synchronized(TaskDataBase::class) {
                    INSTANCE = Room.databaseBuilder(context, TaskDataBase::class.java, "task_db").build()
                }
            }
            return INSTANCE
        }
    }

}