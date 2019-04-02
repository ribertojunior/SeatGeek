package com.example.riberjunior.seatgeek.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.riberjunior.seatgeek.db.SeatGeekDatabase
import com.example.riberjunior.seatgeek.db.dao.EventDao
import com.example.riberjunior.seatgeek.db.entity.Event
import com.example.riberjunior.seatgeek.db.entity.Favorite

class Repository(val db: SeatGeekDatabase,
                 private val eventDao: EventDao){
    val allEvents: LiveData<List<Event>> = eventDao.getAllEvents()

    @WorkerThread
    fun insert(event: Event) {
        eventDao.insert(event)
    }
}