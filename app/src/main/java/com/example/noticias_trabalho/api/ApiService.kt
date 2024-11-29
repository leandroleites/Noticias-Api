package com.example.noticias_trabalho.api

import com.example.noticias_trabalho.model.TopStoriesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("svc/topstories/v2/home.json")
    fun getTopStories(
        @Query("api-key") apiKey: String
    ): Call<TopStoriesResponse>
}