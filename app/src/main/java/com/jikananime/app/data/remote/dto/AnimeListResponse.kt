package com.jikananime.app.data.remote.dto

data class AnimeListResponse(
    val data: List<AnimeDto>
)

data class AnimeDto(
    val mal_id: Int,
    val title: String,
    val url: String,
    val images: ImagesDto
)

data class ImagesDto(
    val jpg: JpgDto
)

data class JpgDto(
    val image_url: String
)