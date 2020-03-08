package com.task.postlisttask.data.local

import androidx.room.*
import com.task.postlisttask.data.entity.PostEntity
import com.task.postlisttask.view.models.Post

@Dao
interface PostDao {
    @Query("SELECT * FROM posts")
    fun getAll(): List<PostEntity>?

    @Query("SELECT * FROM posts WHERE checked = 1")
    fun getCheckedPosts(): List<PostEntity>?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(posts: List<PostEntity>): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(posts: PostEntity): Long


    @Query("DELETE FROM posts")
    fun deleteAll()
}