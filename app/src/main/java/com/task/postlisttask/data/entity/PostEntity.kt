package com.task.postlisttask.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
data class PostEntity(
    val body: String?,
    val email: String?,

    @PrimaryKey
    val id: Int?,
    val name: String?,
    val postId: Int?,
    val checked: Int = 0
)