package com.example.daangnclone.domain.post.util

import com.example.daangnclone.domain.post.data.dto.PostDto
import com.example.daangnclone.domain.post.data.entity.Post

interface PostConverter {
    fun toDto(entity: Post): PostDto
}