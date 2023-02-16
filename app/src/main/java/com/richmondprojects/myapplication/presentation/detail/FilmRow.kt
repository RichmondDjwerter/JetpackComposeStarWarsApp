package com.richmondprojects.myapplication.presentation.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.richmondprojects.myapplication.domain.model.Films

@Composable
fun FilmRow(
    films: Films,
    modifier: Modifier
) {
    Column(modifier = modifier) {
        Card(
            modifier = Modifier.fillMaxSize(),
            shape = MaterialTheme.shapes.medium,
            backgroundColor = Color.DarkGray
        ) {
            Column (modifier = Modifier.fillMaxSize().padding(10.dp)) {
                Text(text = "Title: ${films.title}")
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "Director: ${films.director}")
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = films.opening_crawl,
                    fontWeight = FontWeight.Light,
                    maxLines = 14,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}