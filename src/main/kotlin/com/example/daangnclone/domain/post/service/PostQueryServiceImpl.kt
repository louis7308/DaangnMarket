package com.example.daangnclone.domain.post.service

import com.example.daangnclone.domain.post.data.dto.PostQueryDto
import com.example.daangnclone.domain.post.repository.PostRepository
import com.example.daangnclone.domain.post.repository.PostViewCountRepository
import com.example.daangnclone.domain.post.util.PostConverter
import com.example.daangnclone.domain.post.util.PostQueryConverter
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PostQueryServiceImpl(
    private val postRepository: PostRepository,
    private val postConverter: PostConverter,
    private val postQueryConverter: PostQueryConverter,
    private val postViewCountRepository: PostViewCountRepository
) : PostQueryService {
    override fun findAllPost(pagination: PageRequest): Page<PostQueryDto> =
        postRepository.findBy(pagination)// 페이징 처리 해서 가져온 데이터 * 데이터가 없어도 빈 배열로 반환 해서 보내줌
            .map { postConverter.toDto(it) } // PostDto 형태로 변환
            .map { postViewCountRepository.findById(it.idx) to it} // 게시글 id 에 해당하는 ViewCount 값을 가져온다.
            .map { (if(it.first.isEmpty) 0 else it.first.get().viewCount) to it.second }
            .map { postQueryConverter.toQueryDto(it.first, it.second) }

    override fun findPostByIndex(idx: Long): PostQueryDto {
        val findById = postRepository.findById(idx)
            .let {
                if (it.isEmpty) throw RuntimeException("존재하지 않는 게시글의 인덱스입니다.")
                else it.get()
            }
            .let { postConverter.toDto(it) }
        val viewRedisEntity = postViewCountRepository.findById(findById.idx)
        val toQueryDto = postQueryConverter.toQueryDto(viewRedisEntity.get().viewCount, findById)
        viewRedisEntity.get().viewCount += 1
            .lepostViewCountRepository.save(viewRedisEntity)
    }

}