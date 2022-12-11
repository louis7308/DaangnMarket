package com.example.daangnclone.domain.post.data.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash("post-view-count")
data class PostViewCount(
    @Id
    val postIdx: Long,
    var viewCount: Int
) {
    fun increaseViewCount() {
        viewCount += 1
    }
}
