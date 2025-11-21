package com.jikananime.app.ui.screen.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jikananime.app.data.repository.JikanRepository
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {

    private val repository = JikanRepository()

    fun searchById(id: Int) {
        viewModelScope.launch {
        }
    }
}