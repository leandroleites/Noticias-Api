package com.example.noticias_trabalho.ui.theme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.noticias_trabalho.model.Article
import com.example.noticias_trabalho.viewmodel.TopStoriesViewModel
import androidx.compose.material3.ListItem
import androidx.compose.foundation.clickable
import android.net.Uri
import com.google.gson.Gson
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue





@Composable
fun NewsListScreen(viewModel: TopStoriesViewModel, navController: NavController) {
    val topStoriesResponse by viewModel.topStories.collectAsState()
    val articles = topStoriesResponse?.results ?: emptyList()

    if (articles.isEmpty()) {
        // Mostrar uma mensagem ou um indicador de carregamento
        Text("Nenhuma notícia disponível ou carregando...", modifier = Modifier.padding(16.dp))
    } else {
        LazyColumn {
            items(articles) { article ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            val articleJson = Uri.encode(Gson().toJson(article))
                            navController.navigate("newsDetail/$articleJson")
                        }
                        .padding(16.dp)
                ) {
                    Text(
                        text = article.title,
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}


@Composable
fun NewsItemCard(article: Article) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = article.title, style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = article.abstract, style = MaterialTheme.typography.body2)
        }
    }
}
