package com.example.daangnclone.domain.post.controller

import com.example.daangnclone.domain.post.data.response.PageablePostSummeryQueryResponse
import com.example.daangnclone.domain.post.service.PostQueryService
import com.example.daangnclone.domain.post.util.PostQueryConverter
import org.springframework.data.domain.PageRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/post/query")
class PostQueryController(
    private val postQueryService: PostQueryService,
    private val postQueryConverter: PostQueryConverter
) {
    @GetMapping("/all")
    fun findAllPostWithPagination(
        @RequestParam("page") page: Int,
        @RequestParam("size") size: Int
    ) : ResponseEntity<PageablePostSummeryQueryResponse> =
        postQueryService.findAllPost(PageRequest.of(page, size)) // PageRequest.of 메소드로 protected인 상태인 PageRequest 객체 생성
            .map { postQueryConverter.toSummaryResponse(it) }
            .let { postQueryConverter.toPageableResponse(it.toList()) } // Required : "필요한 리턴 조건" Found : "지금 현재 리턴 타입"
            .let { ResponseEntity.ok(it) }

}