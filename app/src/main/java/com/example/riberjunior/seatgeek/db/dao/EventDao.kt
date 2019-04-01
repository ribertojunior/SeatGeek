package com.example.riberjunior.seatgeek.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.riberjunior.seatgeek.db.entity.Event

@Dao
interface EventDao {
    @Query("SELECT * from event ORDER BY id ASC")
    fun getAllEvents(): LiveData<List<Event>>

    @Query("SELECT * from event  WHERE id = :id")
    fun getEventById(id : Int): LiveData<Event>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(event: Event)

    @Query("DELETE FROM event")
    fun deleteAll()
}