package com.richmondprojects.myapplication.presentation.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination

@Composable
@Destination
fun DetailScreen(
    number: String,
    viewModel: DetailViewModel = hiltViewModel()
) {
    val states = viewModel.states
    if (states.error == null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Character Details",
                fontSize = 25.sp,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(textAlign = TextAlign.Center), fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(10.dp))
            Card(
                modifier = Modifier,
                shape = MaterialTheme.shapes.large,
                backgroundColor = Color.DarkGray
            ) {
                states.results?.let {
                    Column(
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Column(
                                horizontalAlignment = CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(text = "FULL NAME", fontWeight = FontWeight.Light)
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(text = it.name)
                            }
                            Column(
                                horizontalAlignment = CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(text = "SKIN COLOR", fontWeight = FontWeight.Light)
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(text = it.skin_color)
                            }
                            Column(
                                horizontalAlignment = CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(text = "EYE COLOR", fontWeight = FontWeight.Light)
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(text = it.eye_color)
                            }
                        }
                        Divider()
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Column(
                                horizontalAlignment = CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(text = "HEIGHT", fontWeight = FontWeight.Light)
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(text = it.height)
                            }
                            Column(
                                horizontalAlignment = CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(text = "MASS", fontWeight = FontWeight.Light)
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(text = it.mass)
                            }
                            Column(
                                horizontalAlignment = CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(text = "HAIR COLOR", fontWeight = FontWeight.Light)
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(text = it.hair_color)
                            }
                        }
                        Divider()
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Column(
                                horizontalAlignment = CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(text = "GENDER", fontWeight = FontWeight.Light)
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(text = it.gender)
                            }
                            Column(
                                horizontalAlignment = CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(text = "BIRTH YEAR", fontWeight = FontWeight.Light)
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(text = it.birth_year)
                            }
                            Column(
                                horizontalAlignment = CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                states.planets?.let {
                                    Text(text = "Home World", fontWeight = FontWeight.Light)
                                    Spacer(modifier = Modifier.height(6.dp))
                                    Text(text = it.name)
                                }
                            }
                        }
                        Divider()
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Column(
                                horizontalAlignment = CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(text = "VEHICLES", fontWeight = FontWeight.Light)
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(text = it.vehicles.size.toString())
                            }
                            Column(
                                horizontalAlignment = CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(text = "STARSHIPS", fontWeight = FontWeight.Light)
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(text = it.starships.size.toString())
                            }
                            Column(
                                horizontalAlignment = CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(text = "FILMS", fontWeight = FontWeight.Light)
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(text = it.films.size.toString())
                            }
                        }
                    }
                }
            }

            Text(
                text = "Film Catalogue",
                fontWeight = FontWeight.Light,
                modifier = Modifier.padding(5.dp)
            )

            LazyRow(modifier = Modifier.fillMaxSize()) {
                items(states.films.size) { x ->
                    val film = states.films[x]
                    if (film != null) {
                        FilmRow(
                            films = film, modifier = Modifier
                                .fillMaxSize()
                                .padding(5.dp)
                        )
                    }
                }
            }
        }
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (states.isLoading) {
            CircularProgressIndicator()
        } else if (states.error != null) {
            Text(
                text = states.error,
                color = MaterialTheme.colors.error
            )
        }
    }
}