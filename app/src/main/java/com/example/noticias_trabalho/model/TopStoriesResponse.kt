package com.example.noticias_trabalho.model

data class TopStoriesResponse (
    val status: String,
    val results: List<Article>
)