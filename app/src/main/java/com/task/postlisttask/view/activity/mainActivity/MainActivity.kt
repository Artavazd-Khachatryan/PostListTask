package com.task.postlisttask.view.activity.mainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.task.postlisttask.R
import com.task.postlisttask.databinding.ActivityMainBinding
import com.task.postlisttask.view.activity.SHOW_ALL_LIST_FRAGMENT_COMMAND
import com.task.postlisttask.view.activity.SHOW_CHECKED_LIST_FRAGMENT_COMMAND
import com.task.postlisttask.view.fragments.allPostFragment.AllPostListFragment
import com.task.postlisttask.view.fragments.checkedPostListFragment.CheckPostListFragment
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val fragmentContainer = R.id.flFragmentContainer

    private val mainViewModel by inject<MainViewModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createBinding()

        observeCommands()

        showAllPostListFragment()

    }


    private fun createBinding(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = mainViewModel
        binding.lifecycleOwner = this
    }

    private fun observeCommands(){
        mainViewModel.commandLiveData.observe(this, Observer {
            when(it.command){
                SHOW_ALL_LIST_FRAGMENT_COMMAND -> showAllPostListFragment()
                SHOW_CHECKED_LIST_FRAGMENT_COMMAND -> {showCheckedPostListFragment()}
            }
        })
    }


    private fun showAllPostListFragment(){
        val allListFragment =
            supportFragmentManager.findFragmentByTag(AllPostListFragment.TAG) ?:
            AllPostListFragment.newInstance()

        supportFragmentManager
            .beginTransaction()
            .replace(fragmentContainer, allListFragment, AllPostListFragment.TAG)
            .commit()
    }

    private fun showCheckedPostListFragment(){
        val checkListFragment =
            supportFragmentManager.findFragmentByTag(CheckPostListFragment.TAG) ?:
            CheckPostListFragment.newInstance()

        supportFragmentManager
            .beginTransaction()
            .replace(fragmentContainer, checkListFragment, CheckPostListFragment.TAG)
            .commit()
    }
}
