package com.richmondprojects.myapplication.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.richmondprojects.myapplication.domain.model.Results

@Composable
fun ListContent(
    results: Results,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Name: ${results.name}",
                    fontSize = 16.sp,
                    maxLines = 1,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.weight(1f), color = Color(0xFFFFC500)
                )
                Text(text = results.birth_year, fontWeight = FontWeight.Light)
            }
            Text(
                text = "Eye Color: ${results.eye_color}",
                fontWeight = FontWeight.Light,
                fontStyle = FontStyle.Italic
            )
        }
    }
}