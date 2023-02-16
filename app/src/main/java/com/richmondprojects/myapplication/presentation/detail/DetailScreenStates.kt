package com.richmondprojects.myapplication.presentation.detail

import com.richmondprojects.myapplication.domain.model.Films
import com.richmondprojects.myapplication.domain.model.Planets
import com.richmondprojects.myapplication.domain.model.Results

data class DetailScreenStates(
    val results: Results? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
    val planets: Planets? = null,
    val films: ArrayList<Films?> = ArrayList()
)
