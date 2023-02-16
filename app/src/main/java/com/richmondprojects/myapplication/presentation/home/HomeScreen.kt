package com.richmondprojects.myapplication.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.richmondprojects.myapplication.R
import com.richmondprojects.myapplication.presentation.destinations.DetailScreenDestination

@Composable
@Destination(start = true)
fun HomeScreen(
    navigator: DestinationsNavigator,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = viewModel.states.Refresh)
    val states = viewModel.states

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_star_wars),
            contentDescription = "App Logo",
            modifier = Modifier
                .fillMaxHeight(0.13f)
                .fillMaxWidth()
                .align(CenterHorizontally)
                .padding(top = 8.dp)
        )
        OutlinedTextField(
            value = states.searchQuery, onValueChange = {
                viewModel.onEvents(HomeScreenEvents.OnSearchQueryChanged(it))
            }, maxLines = 1, singleLine = true, modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            placeholder = { Text(text = "Search...", color = MaterialTheme.colors.onBackground) },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon"
                )
            })

        SwipeRefresh(
            state = swipeRefreshState,
            onRefresh = { viewModel.onEvents(HomeScreenEvents.isRefreshing) }) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(states.results.size) { x ->
                    val outcome = states.results[x]
                    ListContent(
                        results = outcome,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .clickable {
                                navigator.navigate(
                                    DetailScreenDestination(
                                        outcome.url
                                            .dropLast(1)
                                            .takeLastWhile { it.isDigit() })
                                )
                            }
                    )
                    if (x < states.results.size) {
                        Divider()
                    }
                }
            }
        }
    }
}