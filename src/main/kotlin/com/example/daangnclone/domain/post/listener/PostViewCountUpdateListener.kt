package com.example.daangnclone.domain.post.listener

import com.example.daangnclone.domain.post.data.entity.PostViewCount
import com.example.daangnclone.domain.post.data.event.PostQueryEvent
import com.example.daangnclone.domain.post.repository.PostViewCountRepository
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class PostViewCountUpdateListener(
    private val postViewCountRepository: PostViewCountRepository
) {
    @EventListener(PostQueryEvent::class)
    fun handle(e: PostQueryEvent) {
        postViewCountRepository.existsById(e.idx)
            .let { isExist -> (
                    if (isExist) postViewCountRepository.findById(e.idx).get() // Optional<PostViewCount>
                    else PostViewCount(e.idx, 0)
                ).also { it.increaseViewCount() }
                .let { postViewCountRepository.save(it) }
            }
    }
}