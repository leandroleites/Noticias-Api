package com.example.noticias_trabalho.model

data class Article(
    val section: String,
    val subsection: String?,
    val title: String,
    val abstract: String,
    val url: String,
    val multimedia: List<Multimedia>?,
    val published_date: String
)
