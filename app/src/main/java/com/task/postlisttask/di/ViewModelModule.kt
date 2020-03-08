package com.task.postlisttask.di

import com.task.postlisttask.view.activity.mainActivity.MainViewModel
import com.task.postlisttask.view.fragments.allPostFragment.AllPostListViewModel
import com.task.postlisttask.view.fragments.checkedPostListFragment.CheckPostListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { AllPostListViewModel(get()) }
    viewModel { CheckPostListViewModel(get()) }
}