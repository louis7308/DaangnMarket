package com.example.daangnclone.domain.post.repository

import com.example.daangnclone.domain.post.data.entity.Post
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, Long> {
    fun findBy(pageable : Pageable) : Page<Post> // JPA 레포지토리에 Pageable을 전달하면 반환 타입으로 Slice 혹은 Page를 받는다
}