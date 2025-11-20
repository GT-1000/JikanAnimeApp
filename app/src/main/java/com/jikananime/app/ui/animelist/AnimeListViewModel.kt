package com.jikananime.app.ui.animelist

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jikananime.app.data.remote.dto.AnimeDto
import com.jikananime.app.data.repository.JikanRepository
import kotlinx.coroutines.launch

class AnimeListViewModel : ViewModel() {

    private val repository = JikanRepository()

    private val _animeList = mutableStateOf<List<AnimeDto>>(emptyList())
    val animeList: State<List<AnimeDto>> = _animeList

    init {
        loadAnimeList()
    }

    private fun loadAnimeList() {
        viewModelScope.launch {
            try {
                val response = repository.getAnimeList()
                _animeList.value = response.data
            } catch (e: Exception) {
                e.printStackTrace()
                _animeList.value = emptyList()
            }
        }
    }
}