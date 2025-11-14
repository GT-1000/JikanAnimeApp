package com.jikananime.app.data.repository

import com.jikananime.app.data.remote.NetworkModule
import com.jikananime.app.data.remote.dto.AnimeDetailResponse
import com.jikananime.app.data.remote.dto.AnimeListResponse

class JikanRepository {

    private val api = NetworkModule.api

    suspend fun getAnimeList(): AnimeListResponse {
        return api.getAnimeList()
    }

    suspend fun getAnimeById(id: Int): AnimeDetailResponse {
        return api.getAnimeById(id)
    }
}