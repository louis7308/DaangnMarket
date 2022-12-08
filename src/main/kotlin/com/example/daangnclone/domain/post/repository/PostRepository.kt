package com.example.daangnclone.domain.post.repository

import com.example.daangnclone.domain.post.data.entity.Post
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long> {
    fun findBy(pageable : Pageable) : Page<Post>

}