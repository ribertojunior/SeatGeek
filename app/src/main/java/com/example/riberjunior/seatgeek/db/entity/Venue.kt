package com.example.riberjunior.seatgeek.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "venue")
data class Venue(@PrimaryKey
            @ColumnInfo(name = "venue_id")
            var venue_id: Int,
            @ColumnInfo(name = "postal_code")
            var postal_code: String,
            @ColumnInfo(name = "city")
            var city: String,
            @ColumnInfo(name = "state")
            var state : String,
            @ColumnInfo(name = "address") val address : String)