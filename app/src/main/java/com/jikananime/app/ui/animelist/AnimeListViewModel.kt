package com.jikananime.app.data.remote.dto

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jikananime.app.data.repository.JikanRepository
import kotlinx.coroutines.launch

class AnimeListViewModel : ViewModel() {

    private val repository = JikanRepository()

    init {
        // Hente liste når ViewModel starter
        viewModelScope.launch {
            // TODO: implementer senere
        }
    }
}