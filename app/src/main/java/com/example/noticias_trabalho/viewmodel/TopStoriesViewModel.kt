package com.example.noticias_trabalho.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noticias_trabalho.model.TopStoriesResponse
import com.example.noticias_trabalho.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TopStoriesViewModel : ViewModel() {
    private val repository = NewsRepository()

    private val _topStories = MutableStateFlow<TopStoriesResponse?>(null)
    val topStories: StateFlow<TopStoriesResponse?> = _topStories

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun fetchTopStories(apiKey: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.getTopStories(apiKey).execute()
                if (response.isSuccessful) {
                    val body = response.body()
                    Log.d("TopStoriesViewModel", "Resposta da API: $body") // Verifica os dados aqui
                    _topStories.value = body
                } else {
                    Log.e("TopStoriesViewModel", "Erro da API: ${response.message()}")
                    _error.value = response.message()
                }
            } catch (e: Exception) {
                Log.e("TopStoriesViewModel", "Exceção: ${e.message}", e)
            }
        }
    }
}

