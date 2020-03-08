package com.task.postlisttask.view.models

data class Post(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String,
    var checked: Boolean = false
)