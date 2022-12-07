package com.example.daangnclone.domain.post.service

import com.example.daangnclone.domain.post.data.dto.PostQueryDto
import com.example.daangnclone.domain.post.repository.PostRepository
import com.example.daangnclone.domain.post.util.PostConverter
import com.example.daangnclone.domain.post.util.PostQueryConverter
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class PostQueryServiceImpl(
    private val postRepository: PostRepository,
    private val postConverter: PostConverter,
    private val postQueryConverter: PostQueryConverter
) : PostQueryService {
    override fun findAllPost(pagination: PageRequest): Page<PostQueryDto> =
        postRepository.findBy(pagination)
            .map { postConverter.toDto(it) }
            .map { postQueryConverter.toQueryDto(1, it) }
}