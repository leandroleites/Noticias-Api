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
import coil.compose.AsyncImage
@Composable
fun NewsDetailScreen(article: Article) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = article.title, style = MaterialTheme.typography.h5)
        Text(text = article.abstract, style = MaterialTheme.typography.subtitle1)
        Text(text = article.published_date, style = MaterialTheme.typography.caption)

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = article.abstract, style = MaterialTheme.typography.body1)

        Spacer(modifier = Modifier.height(16.dp))

        // Exibir imagem, se existir
        article.multimedia?.firstOrNull()?.url?.let { imageUrl ->
            AsyncImage(
                model = imageUrl,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
