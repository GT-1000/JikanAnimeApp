package com.jikananime.app.ui.animelist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jikananime.app.data.remote.dto.AnimeDto
import com.jikananime.app.data.repository.JikanRepository
import kotlinx.coroutines.launch

class AnimeListViewModel : ViewModel() {

    private val repository = JikanRepository()

    private val _animeList = mutableStateOf<List<AnimeDto>>(emptyList())
    val animeList: State<List<AnimeDto>> = _animeList

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _errorMessage = mutableStateOf<String?>(null)
    val errorMessage: State<String?> = _errorMessage

    val title = "Top Anime"

    init {
        loadAnimeList()
    }

    private fun loadAnimeList() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                _errorMessage.value = null

                val response = repository.getAnimeList()
                _animeList.value = response.data

            } catch (e: Exception) {
                e.printStackTrace()
                _errorMessage.value = "Could not load anime ❌"
            } finally {
                _isLoading.value = false
            }
        }
    }
}