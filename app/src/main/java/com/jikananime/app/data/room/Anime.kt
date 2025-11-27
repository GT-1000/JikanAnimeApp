package com.jikananime.app.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Anime(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val synopsis: String,
    val creator: String
)
