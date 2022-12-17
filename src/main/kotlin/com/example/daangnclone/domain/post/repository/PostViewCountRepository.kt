package com.example.daangnclone.domain.post.repository

import com.example.daangnclone.domain.post.data.entity.PostViewCount
import org.springframework.data.repository.CrudRepository

interface PostViewCountRepository: CrudRepository<PostViewCount, Long> {
}