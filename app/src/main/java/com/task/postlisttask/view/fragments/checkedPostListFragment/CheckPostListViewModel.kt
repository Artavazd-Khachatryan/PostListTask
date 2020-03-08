package com.task.postlisttask.view.fragments.checkedPostListFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.postlisttask.domain.DataUseCase
import com.task.postlisttask.view.adapters.postListAdapter.PostListAdapter
import com.task.postlisttask.view.models.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CheckPostListViewModel(
    private val dataUseCase: DataUseCase
) : ViewModel(){

    val adapter = PostListAdapter()
        .apply { postChecked = {post, b ->  postItemChecked(post, b)} }



    fun loadData(){
        viewModelScope.launch(Dispatchers.Main){
            val data = dataUseCase.getCheckedPosts()
            adapter.submitList(data)
        }
    }

    private  fun postItemChecked(post: Post, isChecked: Boolean){
        viewModelScope.launch(Dispatchers.Default) {
            dataUseCase.savePost(post)
        }

    }


}