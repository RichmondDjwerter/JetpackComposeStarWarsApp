package com.richmondprojects.myapplication.presentation.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.richmondprojects.myapplication.domain.model.Films
import com.richmondprojects.myapplication.domain.repository.Repository
import com.richmondprojects.myapplication.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: Repository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    var states by mutableStateOf(DetailScreenStates())

    private val filmsList: ArrayList<Films?> = ArrayList()

    init {
        viewModelScope.launch {
            val number = savedStateHandle.get<String>("number") ?: return@launch
            states = states.copy(isLoading = true)

            val characterInfo = async { repository.getCharactersInfo(number) }

            val characterPlanet =
                async { repository.getCharacterPlanets(characterInfo.await().data!!.homeworld) }

            characterInfo.await().data?.films?.forEach { film ->
                val characterFilm = async { repository.getCharacterFilms(film) }
                when (val films = characterFilm.await()) {
                    is Resource.Success -> {
                        filmsList.add(films.data)
                        films.data.let {
                            states = states.copy(
                                films = filmsList,
                                isLoading = false,
                                error = null
                            )
                        }
                    }
                    is Resource.Error -> {
                        states = states.copy(
                            error = films.message,
                            isLoading = false
                        )
                    }
                    else -> {}
                }
            }

            when (val result = characterInfo.await()) {
                is Resource.Success -> {
                    result.data.let {
                        states = states.copy(
                            results = it,
                            isLoading = false,
                            error = null
                        )
                    }
                }
                is Resource.Error -> {
                    states = states.copy(
                        results = null,
                        isLoading = false,
                        error = result.message
                    )
                }
                else -> {}
            }
            when (val response = characterPlanet.await()) {
                is Resource.Success -> {
                    response.data.let {
                        states = states.copy(
                            planets = it,
                            isLoading = false,
                            error = null
                        )
                    }
                }
                is Resource.Error -> {
                    states = states.copy(
                        error = response.message,
                        planets = null,
                        isLoading = false
                    )
                }
                else -> {}
            }
        }
    }
}