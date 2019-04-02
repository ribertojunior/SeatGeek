package com.example.riberjunior.seatgeek.db

import com.example.riberjunior.seatgeek.db.entity.Event
import com.example.riberjunior.seatgeek.db.entity.Favorite
import com.example.riberjunior.seatgeek.db.entity.Venue

class UtilTest {

    companion object {
        fun createEvent(venue_id: Int): Event {
            val id: Int = Math.random().toInt() * 100
            return Event(id, "Churrasco do Bom",
                "2019-04-01T03:30:00", venue_id,
                "food","www.image.com/1221335.jpg", "138.95")
        }

        fun createVenue(): Venue {
            val id: Int = Math.random().toInt() * 100
            return Venue(id, "12860", "Los Angeles", "CA", "Sbornia street")
        }

        fun creatFavorite(event_id: Int): Favorite {
            val id: Int = Math.random().toInt() * 100
            return Favorite(id, event_id)
        }
    }

}