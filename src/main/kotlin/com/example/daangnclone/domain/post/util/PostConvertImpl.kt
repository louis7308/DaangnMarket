package com.example.daangnclone.domain.post.util

import com.example.daangnclone.domain.post.data.dto.PostDto
import com.example.daangnclone.domain.post.data.entity.Post
import org.springframework.stereotype.Component

@Component
class PostConvertImpl: PostConverter {
    override fun toDto(entity: Post): PostDto = PostDto(
        idx = entity.idx,
        title = entity.title,
        content = entity.content,
        price = entity.price,
        isSuggestion = entity.isSuggestion
    )
}