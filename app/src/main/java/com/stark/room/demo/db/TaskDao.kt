package com.stark.room.demo.db

import android.arch.persistence.room.*
import com.stark.room.demo.db.bean.Task

@Dao
interface TaskDao {

    @Query("select * from task order by date desc")
    fun getAllTasks(): List<Task>

    @Insert
    fun insert(task: Task)

    @Update
    fun update(task: Task)

    @Delete
    fun delete(task: Task)
}