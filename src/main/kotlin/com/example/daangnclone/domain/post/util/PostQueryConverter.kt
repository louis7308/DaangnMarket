package com.example.daangnclone.domain.post.util

import com.example.daangnclone.domain.post.data.dto.PostDto
import com.example.daangnclone.domain.post.data.dto.PostQueryDto

interface PostQueryConverter {
    fun toQueryDto(views: Int, dto: PostDto) : PostQueryDto
}