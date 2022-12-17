package com.example.daangnclone.domain.post.util

import com.example.daangnclone.domain.post.data.dto.PostDto
import com.example.daangnclone.domain.post.data.dto.PostQueryDto
import com.example.daangnclone.domain.post.data.event.PostQueryEvent
import com.example.daangnclone.domain.post.data.response.PageablePostSummeryQueryResponse
import com.example.daangnclone.domain.post.data.response.PostQueryResponse
import com.example.daangnclone.domain.post.data.response.PostSummeryQueryResponse
import org.springframework.data.domain.PageImpl
import org.springframework.stereotype.Component

@Component
class PostQueryConverterImpl : PostQueryConverter {
    override fun toQueryDto(views: Int, dto: PostDto): PostQueryDto  = PostQueryDto(
        idx = dto.idx,
        title = dto.title,
        content = dto.content,
        price = dto.price,
        isSuggestion = dto.isSuggestion,
        views = views
    )

    override fun toSummaryResponse(dto: PostQueryDto): PostSummeryQueryResponse = PostSummeryQueryResponse(
        idx = dto.idx,
        title = dto.title,
        content = dto.content,
        price = dto.price,
        isSuggestion = dto.isSuggestion,
        views = dto.views
    )

    override fun toPageableResponse(list: List<PostSummeryQueryResponse>): PageablePostSummeryQueryResponse = PageablePostSummeryQueryResponse(
        PageImpl(list)
    )

    override fun toResponse(dto: PostQueryDto): PostQueryResponse = PostQueryResponse(
        idx = dto.idx,
        title = dto.title,
        content = dto.content,
        price = dto.price,
        isSuggestion = dto.isSuggestion,
        views = dto.views
    )

    override fun toEvent(dto: PostQueryDto): PostQueryEvent = PostQueryEvent(
        idx = dto.idx,
        title = dto.title,
        content = dto.content,
        price = dto.price,
        isSuggestion = dto.isSuggestion,
        views = dto.views
    )
}