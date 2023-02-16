package com.richmondprojects.myapplication.data.remote.dto

data class CharactersDto(
    val count: Int,
    val next: String,
    val previous: String?,
    val results: List<ResultsDto>
)