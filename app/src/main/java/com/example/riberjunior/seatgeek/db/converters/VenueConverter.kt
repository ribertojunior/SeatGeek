package com.example.riberjunior.seatgeek.db.converters

import androidx.room.TypeConverter
import com.example.riberjunior.seatgeek.db.entity.Venue
import com.google.gson.Gson

class VenueConverter {

    @TypeConverter
    fun stringToVenue( data: String?) : Venue {
        return Gson().fromJson(data, Venue::class.java)
    }

    @TypeConverter
    fun venueToString(venue: Venue) : String {
        return Gson().toJson(venue)
    }
}