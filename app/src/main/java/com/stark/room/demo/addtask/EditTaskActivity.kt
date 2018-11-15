package com.stark.room.demo.addtask

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.stark.room.demo.db.bean.Task

class EditTaskActivity : AddTaskActivity() {

    companion object {
        fun start(context: Context, task: Task) {
            context.startActivity(Intent(context, EditTaskActivity::class.java).apply { putExtra("task", task) })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding.viewModel?.task = intent.getParcelableExtra("task")
        mBinding.delBtn.visibility = View.VISIBLE
    }

    override fun onSave() {
        mBinding.viewModel?.update()
        finish()
    }

    override fun onDelete() {
        mBinding.viewModel?.delete()
        finish()
    }
}