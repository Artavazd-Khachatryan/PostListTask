package com.task.postlisttask.data.repository


import com.task.postlisttask.data.entity.PostEntity
import com.task.postlisttask.data.local.PostDao
import com.task.postlisttask.data.mapper.Mapper
import com.task.postlisttask.data.remute.Api
import com.task.postlisttask.view.models.Post

class Repository(private val api: Api,
                 private val postDao: PostDao,
private val mapper: Mapper<Post, PostEntity>){

    suspend fun getRemotePosts() = mapper.reverseMap(api.getPosts())

    fun getLocalPosts() = mapper.reverseMap(postDao.getAll() ?: emptyList())

    fun getCheckedPosts() = mapper.reverseMap(postDao.getCheckedPosts() ?: emptyList())

    fun savePosts(posts: List<Post>) = postDao.insertAll(mapper.map(posts))

    fun savePost(post: Post) = postDao.insert(mapper.map(post))

    fun deletePosts() = postDao.deleteAll()

}