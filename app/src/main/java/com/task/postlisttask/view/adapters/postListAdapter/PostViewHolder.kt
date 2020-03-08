package com.task.postlisttask.view.adapters.postListAdapter

import android.widget.ToggleButton
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.RecyclerView
import com.task.postlisttask.databinding.PostItemBinding
import com.task.postlisttask.view.models.Post

class PostViewHolder(private val binding: PostItemBinding) : RecyclerView.ViewHolder(binding.root) {
    val post = ObservableField<Post>()

    var postChecked: (Post, Boolean) -> Unit = { post, b -> }

    fun bind(post: Post) {
        this.post.set(post)
        binding.holder = this

        binding.tbChecked.setOnCheckedChangeListener { buttonView, isChecked ->
            this.post.get()?.let {
                it.checked = isChecked
                postChecked(it, isChecked)
            }


        }
    }


}