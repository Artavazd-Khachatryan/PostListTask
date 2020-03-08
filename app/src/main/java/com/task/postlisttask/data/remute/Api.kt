package com.task.postlisttask.data.remute
import com.task.postlisttask.data.entity.PostEntity
import io.ktor.client.HttpClient
import io.ktor.client.request.get


private const val LESSON_URL = "https://jsonplaceholder.typicode.com/comments"
class Api(private val client: HttpClient){

    suspend fun getPosts() = client.get<List<PostEntity>>(LESSON_URL)

}