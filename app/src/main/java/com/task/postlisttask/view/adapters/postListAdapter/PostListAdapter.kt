package com.task.postlisttask.view.adapters.postListAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.task.postlisttask.databinding.PostItemBinding
import com.task.postlisttask.view.models.Post

class PostListAdapter: ListAdapter<Post, PostViewHolder>(PostListDiffUtil()){

    var postChecked: ((Post, Boolean) -> Unit)?  = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = PostItemBinding.inflate(layoutInflater, parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
       holder.bind(getItem(position))
        postChecked?.let { holder.postChecked = it }

    }

}