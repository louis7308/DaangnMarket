package com.example.daangnclone.domain.post.service

import com.example.daangnclone.domain.post.data.dto.PostQueryDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest

class PostQueryServiceImpl(

) : PostQueryService {
    override fun findAllPost(pagination: PageRequest): Page<PostQueryDto> {
        TODO("Not yet implemented")
    }
}