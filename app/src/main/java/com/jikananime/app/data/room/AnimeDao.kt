package com.jikananime.app.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AnimeDao {

    @Query("SELECT * FROM Anime")
    suspend fun getAllAnime() : List<Anime>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnime(newAnime: Anime) : Long

    @Query("DELETE FROM Anime WHERE id = :id")
    suspend fun deleteAnimeById(id: Int)
}

