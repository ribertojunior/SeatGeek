package com.example.riberjunior.seatgeek.db.converters

import androidx.room.TypeConverter
import com.example.riberjunior.seatgeek.db.entity.Event
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

class EventConverter {

    @TypeConverter
    fun stringToEvent(data: String?): List<Event> {
        if (data == null) {
            return Collections.emptyList()
        }
        val listEvent = object : TypeToken<List<Event>>() {}.type
        return Gson().fromJson(data, listEvent)
    }

    @TypeConverter
    fun EventToString(events: List<Event>) : String {
        return Gson().toJson(events)
    }
}