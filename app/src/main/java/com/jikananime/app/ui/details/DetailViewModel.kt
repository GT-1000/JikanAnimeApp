package com.jikananime.app.ui.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jikananime.app.data.remote.dto.AnimeDetailDto
import com.jikananime.app.data.repository.JikanRepository
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {

    private val repository = JikanRepository()

    val anime = mutableStateOf<AnimeDetailDto?>(null)
    val loading = mutableStateOf(false)
    val error = mutableStateOf<String?>(null)

    fun loadAnime(id: Int) {
        viewModelScope.launch {
            try {
                loading.value = true
                error.value = null

                val response = repository.getAnimeById(id)
                anime.value = response.data

            } catch (e: Exception) {
                error.value = "Kunne ikke hente detaljer ❌"
            } finally {
                loading.value = false
            }
        }
    }
}