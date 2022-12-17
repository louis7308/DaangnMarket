package com.example.daangnclone.domain.post.util

import com.example.daangnclone.domain.post.data.dto.PostDto
import com.example.daangnclone.domain.post.data.dto.PostQueryDto
import com.example.daangnclone.domain.post.data.event.PostQueryEvent
import com.example.daangnclone.domain.post.data.response.PageablePostSummeryQueryResponse
import com.example.daangnclone.domain.post.data.response.PostQueryResponse
import com.example.daangnclone.domain.post.data.response.PostSummeryQueryResponse

interface PostQueryConverter {
    fun toQueryDto(views: Int, dto: PostDto) : PostQueryDto
    fun toSummaryResponse(dto: PostQueryDto): PostSummeryQueryResponse
    fun toPageableResponse(list: List<PostSummeryQueryResponse>): PageablePostSummeryQueryResponse
    fun toResponse(dto: PostQueryDto): PostQueryResponse

    fun toEvent(dto: PostQueryDto): PostQueryEvent
}