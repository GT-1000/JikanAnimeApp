package com.jikananime.app.data.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Anime::class],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase(){
    abstract fun animeDao() : AnimeDao
}