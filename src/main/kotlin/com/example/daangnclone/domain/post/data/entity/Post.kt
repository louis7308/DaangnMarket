package com.example.daangnclone.domain.post.data.entity

import com.example.daangnclone.global.entity.BaseTimeEntity
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Post(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // @Id 기본키 @GeneratedValue 기본키 생성 조건 IDENTITY 생성될 때 마다 1씩 증가
    val idx: Long,
    val title: String,
    val content: String,
    val price: Long,
    val isSuggestion: Boolean,
) : BaseTimeEntity() {

}