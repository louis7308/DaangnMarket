package com.example.daangnclone.domain.post.data.response

data class PostSummeryQueryResponse(
    val idx: Long,
    val title: String,
    val content: String,
    val price: Long,
    val isSuggestion: Boolean,
    val views: Int
)