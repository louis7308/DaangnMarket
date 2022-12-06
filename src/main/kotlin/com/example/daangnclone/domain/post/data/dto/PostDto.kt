package com.example.daangnclone.domain.post.data.dto

data class PostDto(
    val idx: Long,
    val title: String,
    val content: String,
    val price: Long,
    val isSuggestion: Boolean
)
