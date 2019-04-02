package com.example.riberjunior.seatgeek.db

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import androidx.test.runner.AndroidJUnit4
import com.example.riberjunior.seatgeek.db.dao.EventDao
import com.example.riberjunior.seatgeek.db.dao.FavoriteDao
import com.example.riberjunior.seatgeek.db.dao.VenueDao
import org.junit.Before
import org.junit.runner.RunWith
import androidx.test.core.app.ApplicationProvider
import com.example.riberjunior.seatgeek.db.entity.Event
import org.hamcrest.core.IsEqual.equalTo
import org.junit.After
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertThat
import org.junit.Test
import java.lang.Exception

@RunWith(AndroidJUnit4::class)
class DbInstrumentedTest {
    private lateinit var eventDao: EventDao
    private lateinit var favoriteDao: FavoriteDao
    private lateinit var venueDao: VenueDao
    private lateinit var db: SeatGeekDatabase

    @Before
    fun createDB() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, SeatGeekDatabase::class.java).build()

        eventDao = db.eventDao()
        favoriteDao = db.favoriteDao()
        venueDao = db.venueDao()
    }


    @After
    fun closeDb(){
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeAndRead(){
        val venue = UtilTest.createVenue()
        val event = UtilTest.createEvent(venue.venue_id)
        val favorite = UtilTest.creatFavorite(event.id)
        venueDao.insert(venue)
        val venueByID = venueDao.getVenue(venue.venue_id)
        assertThat(venueByID, equalTo(venue))
        eventDao.insert(event)
        val eventById = eventDao.getEventById(event.id)
        assertNotNull(eventById)
        favoriteDao.insert(favorite)
        val favoriteById = favoriteDao.getFavorite(favorite.id)
        assertThat(favoriteById, equalTo(favorite))

    }

}