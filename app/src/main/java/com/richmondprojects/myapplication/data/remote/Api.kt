package com.richmondprojects.myapplication.data.remote

import com.richmondprojects.myapplication.data.remote.dto.CharactersDto
import com.richmondprojects.myapplication.data.remote.dto.FilmsDto
import com.richmondprojects.myapplication.data.remote.dto.PlanetsDto
import com.richmondprojects.myapplication.data.remote.dto.ResultsDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface Api {

    @GET("people")
    suspend fun getCharacters(
        @Query("page") page: Int
    ): CharactersDto

    @GET("people/{number}")
    suspend fun getCharacterInfo(
        @Path("number") number: String
    ): ResultsDto

    @GET
    suspend fun getCharacterPlanet(
        @Url url: String
    ): PlanetsDto

    @GET
    suspend fun getCharacterFilms(
        @Url url: String
    ): FilmsDto
}