package com.example.riberjunior.seatgeek.db.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.riberjunior.seatgeek.db.dao.EventDao
import com.example.riberjunior.seatgeek.db.entity.Event

class Repository(private val eventDao: EventDao){
    val allEvents: LiveData<List<Event>> = eventDao.getAllEvents()
    @WorkerThread
    suspend fun insert(event: Event) {
        eventDao.insert(event)
    }
}