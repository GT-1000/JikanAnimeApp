package com.jikananime.app.data.remote

import com.jikananime.app.data.remote.dto.AnimeDetailResponse
import com.jikananime.app.data.remote.dto.AnimeListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface JikanApiService {

    @GET("anime")
    suspend fun getAnimeList(): AnimeListResponse

    @GET("anime/{id}")
    suspend fun getAnimeById(
        @Path("id") id: Int
    ): AnimeDetailResponse
}