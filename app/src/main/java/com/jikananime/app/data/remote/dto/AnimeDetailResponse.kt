package com.jikananime.app.data.remote.dto

data class AnimeDetailResponse(
    val data: AnimeDetailDto
)

data class AnimeDetailDto(
    val mal_id: Int,
    val title: String,
    val synopsis: String,
    val images: ImagesDto
)