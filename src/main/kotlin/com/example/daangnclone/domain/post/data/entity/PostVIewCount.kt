package com.example.daangnclone.domain.post.data.entity

import org.springframework.data.redis.core.RedisHash
import javax.persistence.Id

@RedisHash("post-view-count")
data class PostVIewCount(
    @Id
    val postIdx: Long,
    var viewCount: Int
)
