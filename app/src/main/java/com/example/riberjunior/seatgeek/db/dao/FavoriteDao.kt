package com.example.riberjunior.seatgeek.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.riberjunior.seatgeek.db.entity.Favorite

@Dao
interface FavoriteDao {
    @Query ("SELECT * FROM favorite ORDER BY id ASC")
    fun getAllFavorites(): List<Favorite>

    @Query ("SELECT * FROM favorite WHERE id = :id ORDER BY id ASC")
    fun getFavorite(id : Int): Favorite

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(favorite: Favorite)
}