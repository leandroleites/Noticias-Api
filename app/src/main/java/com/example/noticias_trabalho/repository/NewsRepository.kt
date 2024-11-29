package com.example.noticias_trabalho.repository

import com.example.noticias_trabalho.api.RetrofitInstance

class NewsRepository {
    private val api = RetrofitInstance.api

    fun getTopStories(apiKey: String) = api.getTopStories(apiKey)
}
