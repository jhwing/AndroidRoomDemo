package com.stark.room.demo.addtask

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.MenuItem
import com.stark.room.demo.R
import com.stark.room.demo.databinding.ActivityAddTaskBinding
import org.jetbrains.anko.toast

open class AddTaskActivity : AppCompatActivity(), AddTaskActionsListener {
    override fun onDelete() {

    }

    override fun onSave() {
        val name = mBinding.taskNameEt.text.toString()
        if (TextUtils.isEmpty(name)) {
            toast("name is empty!")
            return
        }
        mBinding.viewModel?.save(name)
        finish()
    }

    lateinit var mBinding: ActivityAddTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_task)
        mBinding.viewModel = ViewModelProviders.of(this).get(AddTaskViewModel::class.java)
        mBinding.listener = this
        setSupportActionBar(mBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}