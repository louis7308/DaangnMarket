package com.example.daangnclone.domain.post.service

import com.example.daangnclone.domain.post.data.dto.PostQueryDto
import com.example.daangnclone.domain.post.repository.PostRepository
import com.example.daangnclone.domain.post.repository.PostViewCountRepository
import com.example.daangnclone.domain.post.util.PostConverter
import com.example.daangnclone.domain.post.util.PostQueryConverter
import org.springframework.context.ApplicationEventPublisher
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.EventListener

@Service
class PostQueryServiceImpl(
    private val postRepository: PostRepository,
    private val postConverter: PostConverter,
    private val postQueryConverter: PostQueryConverter,
    private val postViewCountRepository: PostViewCountRepository,
    private val applicationEventPublisher: ApplicationEventPublisher
) : PostQueryService {
    override fun findAllPost(pagination: PageRequest): Page<PostQueryDto> =
        postRepository.findBy(pagination)// 페이징 처리 해서 가져온 데이터 * 데이터가 없어도 빈 배열로 반환 해서 보내줌
            .map { postConverter.toDto(it) } // PostDto 형태로 변환
            .map { postViewCountRepository.findById(it.idx) to it } // 게시글 id 에 해당하는 ViewCount 값을 가져온다.
            .map { (if (it.first.isEmpty) 0 else it.first.get().viewCount) to it.second }
            .map { postQueryConverter.toQueryDto(it.first, it.second) }


    override fun findPostByIndex(idx: Long): PostQueryDto =
        postRepository.findById(idx)// DataBase 에서 idx 에 맞는 Entity 가져올거 아냐 Return : Optional<Post> = "id: 1, title: "하이"
            .orElseThrow{ RuntimeException("존재하지 않는 게시글의 인덱스 입니다 ${idx}")}// Optional 이 null이면 이 구문이 실행됨
            .let { postConverter.toDto(it) }//
            .let { postViewCountRepository.findById(it.idx) to it } //Pair<Optional<PairViewCount!, PostDto>
            .let { (if(it.first.isEmpty) 0 else it.first.get().viewCount) to it.second } // Pair<0 || viewCount값, PostDto>
            .let { postQueryConverter.toQueryDto(it.first, it.second) }
            .also { this.publishEvent(it)} // this::publishEvent 로 대체 가능

    private fun publishEvent(dto: PostQueryDto) =
        postQueryConverter.toEvent(dto)
            .let { applicationEventPublisher.publishEvent(it) }
}