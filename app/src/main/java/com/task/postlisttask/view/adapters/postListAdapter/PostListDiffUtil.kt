package com.task.postlisttask.view.adapters.postListAdapter

import androidx.recyclerview.widget.DiffUtil
import com.task.postlisttask.view.models.Post


class PostListDiffUtil: DiffUtil.ItemCallback<Post>() {

    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem == newItem
    }

}