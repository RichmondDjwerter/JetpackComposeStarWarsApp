package com.richmondprojects.myapplication.presentation.home

import com.richmondprojects.myapplication.domain.model.Results

data class HomeScreenStates(
    val results: List<Results> = emptyList(),
    val isLoading: Boolean = false,
    val Refresh: Boolean = false,
    val searchQuery: String = "",
    val endReached: Boolean = false
)
