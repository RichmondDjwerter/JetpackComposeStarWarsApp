package com.richmondprojects.myapplication.presentation.home

sealed class HomeScreenEvents {

    object isRefreshing : HomeScreenEvents()

    data class OnSearchQueryChanged(val query: String) : HomeScreenEvents()
}
