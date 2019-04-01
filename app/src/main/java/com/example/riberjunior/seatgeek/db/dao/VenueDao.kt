package com.example.riberjunior.seatgeek.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.riberjunior.seatgeek.db.entity.Venue

@Dao
interface VenueDao {
    @Query("SELECT * FROM venue ORDER BY venue_id ASC")
    fun getAllVenues(): List<Venue>

    @Query("SELECT * FROM venue WHERE venue_id = :id ORDER BY venue_id ASC")
    fun getVenue(id : Int): Venue

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(venue: Venue)

    @Query("DELETE FROM venue")
    fun deleteAll()
}