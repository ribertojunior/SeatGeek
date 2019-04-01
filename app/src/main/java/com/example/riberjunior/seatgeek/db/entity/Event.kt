package com.example.riberjunior.seatgeek.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "event",
        foreignKeys = arrayOf(
            ForeignKey(
            entity = Venue::class,
                parentColumns = arrayOf("venue_id"),
                childColumns = arrayOf("venue_id")
        )))
data class  Event(@PrimaryKey
                   @ColumnInfo(name = "id")
                   var id : Int,
                  @ColumnInfo(name = "title")
                   var title : String,
                  @ColumnInfo(name = "datetime_local")
                   var datetime_local : String,
                  @ColumnInfo(name = "venue_id")
                   var venue_id : Int,
                  @ColumnInfo(name = "type")
                   var type : String,
                  @ColumnInfo(name = "image")
                   var image : String,
                  @ColumnInfo(name = "lowest_price")
                   var lowest_price : String
)