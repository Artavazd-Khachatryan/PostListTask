package com.task.postlisttask.view.fragments.allPostFragment

import android.view.View.GONE
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.postlisttask.domain.DataUseCase
import com.task.postlisttask.view.adapters.postListAdapter.PostListAdapter
import com.task.postlisttask.view.models.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllPostListViewModel(
    private val dataUseCase: DataUseCase
) : ViewModel(){


    val adapter = PostListAdapter()
        .apply { postChecked = {post, b ->  postItemChecked(post, b)} }

    val progressVisible = MutableLiveData<Int>()


    fun loadData(){
        viewModelScope.launch(Dispatchers.Main){
            val data = dataUseCase.getPosts()
            adapter.submitList(data)
            progressVisible.value = GONE
        }
    }

    private  fun postItemChecked(post: Post, isChecked: Boolean){
        viewModelScope.launch(Dispatchers.Default) {
            dataUseCase.savePost(post)
        }

    }

}