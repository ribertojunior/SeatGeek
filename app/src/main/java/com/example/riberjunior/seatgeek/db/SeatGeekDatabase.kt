package com.example.riberjunior.seatgeek.db

import android.content.Context
import androidx.room.*
import com.example.riberjunior.seatgeek.db.converters.EventConverter
import com.example.riberjunior.seatgeek.db.converters.VenueConverter
import com.example.riberjunior.seatgeek.db.dao.EventDao
import com.example.riberjunior.seatgeek.db.dao.FavoriteDao
import com.example.riberjunior.seatgeek.db.dao.VenueDao
import com.example.riberjunior.seatgeek.db.entity.Event
import com.example.riberjunior.seatgeek.db.entity.Favorite
import com.example.riberjunior.seatgeek.db.entity.Venue
import java.security.AccessControlContext

@Database(entities = arrayOf(Event::class, Venue::class, Favorite::class), version = 1)
@TypeConverters(
    EventConverter::class,
    VenueConverter::class)
abstract class SeatGeekDatabase : RoomDatabase() {
    abstract fun eventDao(): EventDao

    abstract fun venueDao(): VenueDao

    abstract fun favoriteDao(): FavoriteDao

    companion object {
        @Volatile
        private var INSTANCE: SeatGeekDatabase? = null

        fun getDatabase(context: Context): SeatGeekDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SeatGeekDatabase::class.java,
                    "SeatGeekDatabase"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}