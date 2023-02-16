package com.richmondprojects.myapplication.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ResultsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacters(resultsEntity: List<ResultsEntity>)

    @Query("DELETE FROM resultsentity")
    suspend fun clearCharacters()

    @Query(
        """
        SELECT * FROM resultsentity
        WHERE LOWER(name) LIKE '%'|| LOWER(:query) || '%'
        OR LOWER(:query) == LOWER(eye_color)
    """
    )
    suspend fun searchCharacters(query: String): List<ResultsEntity>
}