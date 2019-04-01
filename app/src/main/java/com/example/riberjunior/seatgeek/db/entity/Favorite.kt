package com.example.riberjunior.seatgeek.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "favorite",
        foreignKeys = arrayOf(
            ForeignKey(
                entity = Event::class,
                parentColumns = arrayOf("id"),
                childColumns = arrayOf("event_id"))
))
data class Favorite(@PrimaryKey
                      @ColumnInfo(name = "id")
                     var id : Int,
                    @ColumnInfo(name = "event_id") var event_id : Int

)