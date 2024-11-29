package com.example.noticias_trabalho

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.noticias_trabalho.ui.theme.Noticias_TrabalhoTheme
import com.example.noticias_trabalho.ui.theme.NewsListScreen
import com.example.noticias_trabalho.ui.theme.NewsDetailScreen
import com.example.noticias_trabalho.viewmodel.TopStoriesViewModel
import com.example.noticias_trabalho.model.Article
import android.net.Uri
import com.google.gson.Gson
import android.util.Log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val apiKey = "Jy0GM2QUUTUzDnM9qL1uAKLlCdpqITnB"

        setContent {
            val viewModel: TopStoriesViewModel = viewModel()
            val navController = rememberNavController()
            Log.d("MainActivity", "fetchTopStories chamado com apiKey: $apiKey")
            Noticias_TrabalhoTheme {
                NavHost(navController = navController, startDestination = "newsList") {
                    composable("newsList") {
                        NewsListScreen(viewModel = viewModel, navController = navController)
                    }
                    composable("newsDetail/{article}") { backStackEntry ->
                        val articleJson = backStackEntry.arguments?.getString("article")
                        val article = Gson().fromJson(articleJson, Article::class.java)
                        NewsDetailScreen(article = article)
                    }
                }
            }
        }
    }
}

