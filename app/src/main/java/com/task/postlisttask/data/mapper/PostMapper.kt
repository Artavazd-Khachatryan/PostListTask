package com.task.postlisttask.data.mapper

import com.task.postlisttask.data.entity.PostEntity
import com.task.postlisttask.view.models.Post


class PostMapper: Mapper<Post, PostEntity>{

    override fun map(value: Post): PostEntity {

        return PostEntity(
            value.body,
            value.email,
            value.id,
            value.name,
            value.postId,
            if(value.checked) 1 else 0)
    }

    override fun reverseMap(value: PostEntity): Post {
        var resultProduct: Post? = null
        value.apply {
            resultProduct = Post(
                postId?: -1,
                id?: -1,
                name?: "",
                email?: "",
                body?: "",
                checked == 1
            )
        }

        return resultProduct!!
    }
}