package com.stark.room.demo.main

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import com.stark.room.demo.R
import com.stark.room.demo.addtask.AddTaskActivity
import com.stark.room.demo.addtask.EditTaskActivity
import com.stark.room.demo.databinding.ActivityMainBinding
import com.stark.room.demo.db.bean.Task

class MainActivity : AppCompatActivity(), MainListAdapter.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener {
    override fun onRefresh() {

    }

    override fun onItemClick(task: Task) {
        EditTaskActivity.start(this, task)
    }

    lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(mBinding.toolbar)
        mBinding.viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        mBinding.mainTaskListView.layoutManager = LinearLayoutManager(this)
        mBinding.mainTaskListView.adapter = MainListAdapter(this).apply {
            onItemClickListener = this@MainActivity
        }
    }

    override fun onStart() {
        super.onStart()
        mBinding.viewModel?.load()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.addTask -> {
                startActivity(Intent(this, AddTaskActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
