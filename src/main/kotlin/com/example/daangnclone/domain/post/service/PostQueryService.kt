package com.example.daangnclone.domain.post.service

import com.example.daangnclone.domain.post.data.dto.PostQueryDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest

interface PostQueryService {
    fun findAllPost(pagination: PageRequest) : Page<PostQueryDto>
}