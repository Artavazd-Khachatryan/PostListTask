package com.task.postlisttask.domain


import com.task.postlisttask.data.entity.PostEntity
import com.task.postlisttask.data.repository.Repository
import com.task.postlisttask.view.models.Post
import kotlinx.coroutines.*


class DataUseCase(
    private val repository: Repository,
    private val networkManager: NetworkConnectionManager,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend fun getPosts() = if (networkManager.isInternetAvailable()) {
        repository.getRemotePosts().run {
            savePosts(this)
            withContext(dispatcher){repository.getLocalPosts()}
        }
    } else
        withContext(dispatcher){repository.getLocalPosts()}

    suspend fun getCheckedPosts() = withContext(dispatcher){repository.getCheckedPosts()}

    suspend fun savePosts(posts: List<Post>) = withContext(dispatcher){
        repository.savePosts(posts)
    }

    suspend fun savePost(post: Post) = withContext(dispatcher){repository.savePost(post)}

    suspend fun deletePosts() = withContext(dispatcher){repository.deletePosts()}


}
