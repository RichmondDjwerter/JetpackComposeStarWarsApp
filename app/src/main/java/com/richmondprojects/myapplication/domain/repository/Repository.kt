package com.richmondprojects.myapplication.domain.repository

import com.richmondprojects.myapplication.domain.model.Films
import com.richmondprojects.myapplication.domain.model.Planets
import com.richmondprojects.myapplication.domain.model.Results
import com.richmondprojects.myapplication.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun getCharacters(
        page: Int,
        query: String,
        fetchFromRemote: Boolean
    ): Flow<Resource<List<Results>>>

    suspend fun getCharactersInfo(
        number: String
    ): Resource<Results>

    suspend fun getCharacterPlanets(
        url: String
    ): Resource<Planets>

    suspend fun getCharacterFilms(
        url: String
    ): Resource<Films>
}