package com.richmondprojects.myapplication.data.mappers

import com.richmondprojects.myapplication.data.local.ResultsEntity
import com.richmondprojects.myapplication.data.remote.dto.FilmsDto
import com.richmondprojects.myapplication.data.remote.dto.PlanetsDto
import com.richmondprojects.myapplication.data.remote.dto.ResultsDto
import com.richmondprojects.myapplication.domain.model.Films
import com.richmondprojects.myapplication.domain.model.Planets
import com.richmondprojects.myapplication.domain.model.Results

fun ResultsDto.toResultsDomain(): Results {
    return Results(
        birth_year = birth_year,
        created = created,
        edited = edited,
        eye_color = eye_color,
        films = films,
        gender = gender,
        hair_color = hair_color,
        height = height,
        homeworld = homeworld,
        mass = mass,
        name = name,
        skin_color = skin_color,
        species = species,
        starships = starships,
        url = url,
        vehicles = vehicles
    )
}

fun Results.toResultsEntity(): ResultsEntity {
    return ResultsEntity(
        birth_year = birth_year,
        created = created,
        edited = edited,
        eye_color = eye_color,
        gender = gender,
        hair_color = hair_color,
        height = height,
        homeworld = homeworld,
        mass = mass,
        name = name,
        skin_color = skin_color,
        url = url,
    )
}

fun ResultsEntity.toResults(): Results {
    return Results(
        birth_year = birth_year,
        created = created,
        edited = edited,
        eye_color = eye_color,
        gender = gender,
        hair_color = hair_color,
        height = height,
        homeworld = homeworld,
        mass = mass,
        name = name,
        skin_color = skin_color,
        url = url,
    )
}

fun PlanetsDto.toPlanetsDomain(): Planets {
    return Planets(
        climate = climate,
        created = created,
        diameter = diameter,
        edited = edited,
        films = films,
        gravity = gravity,
        name = name,
        orbital_period = orbital_period,
        population = population,
        residents = residents,
        rotation_period = rotation_period,
        surface_water = surface_water,
        terrain = terrain,
        url = url
    )
}

fun FilmsDto.toFilmsDomain(): Films {
    return Films(
        characters,
        created,
        director,
        edited,
        episode_id,
        opening_crawl,
        planets,
        producer,
        release_date,
        species,
        starships,
        title,
        url,
        vehicles
    )
}
