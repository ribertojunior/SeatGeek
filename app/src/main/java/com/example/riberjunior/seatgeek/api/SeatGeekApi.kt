package com.example.riberjunior.seatgeek.api

import android.util.Log
import com.example.riberjunior.seatgeek.db.entity.Event
import com.example.riberjunior.seatgeek.db.entity.Venue
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SeatGeekApi{
    @GET("/events")
    fun getEvents(
        @Query("limit") limit: Int): Call<ListingEventResponse>

    @GET("/events/{event_id}")
    fun getEventByID(
        @Path("event_id") event_id: String,
        @Query("limit") limit: Int): Call<SeatGeekEvent>

    @GET("/venues/{venue_id}")
    fun getVenurById(
        @Path("venue_id") venue_id: String,
        @Query("limite") limit: Int): Call<SeatGeekVenue>




    class ListingEventResponse (val data: ListingData)

    class ListingData(
        val children: List<SeatGeekEvent>
    )

    data class SeatGeekEvent( val data: Event)

    data class SeatGeekVenue(val data: Venue)

    companion object {
        private const val BASE_URL = "https://api.seatgeek.com/2/"
        fun create(): SeatGeekApi = create(HttpUrl.parse(BASE_URL)!!)
        fun create(httpUrl: HttpUrl) : SeatGeekApi {
            val url = httpUrl.newBuilder().addQueryParameter("client_id", "MTYwMTIzNjB8MTU1NDEyMTg2NS45Nw").toString()
            val logger = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
                Log.d("API", it)
            })
            logger.level = HttpLoggingInterceptor.Level.BASIC

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
            return Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SeatGeekApi::class.java)
        }
    }
}