package com.jikananime.app.ui.screen.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jikananime.app.data.remote.dto.AnimeDetailDto
import com.jikananime.app.data.repository.JikanRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {

    private val repository = JikanRepository()

    private val _anime = MutableStateFlow<AnimeDetailDto?>(null)
    val anime = _anime.asStateFlow()

    private val _error = MutableStateFlow<String?>(null)
    val error = _error.asStateFlow()

    private val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    fun searchById(id: Int) {
        viewModelScope.launch {
            try {
                _error.value = null
                _anime.value = null
                _loading.value = true

                val response = repository.getAnimeById(id)
                _anime.value = response.data

                if (response.data == null) {
                    _error.value = "Fant ingen anime med ID $id"
                }
            } catch (e: Exception){
                e.printStackTrace()
                _error.value = "Fant ingen anime med ID $id"
            } finally {
                _loading.value = false
            }
        }
    }
}