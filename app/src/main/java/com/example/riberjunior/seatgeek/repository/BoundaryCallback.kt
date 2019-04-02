package com.example.riberjunior.seatgeek.repository

import androidx.paging.PagedList
import com.example.riberjunior.seatgeek.androidx.paging.PagingRequestHelper
import com.example.riberjunior.seatgeek.api.SeatGeekApi
import com.example.riberjunior.seatgeek.db.entity.Event
import com.example.riberjunior.seatgeek.util.createStatusLiveData
import java.util.concurrent.Executor


class BoundaryCallback(
    private val event_id: String,
    private val venue_id: String,
    private val service: SeatGeekApi,
    private val handleResponse: (String, SeatGeekApi.ListingEventResponse?) -> Unit,
    private val ioExecutor: Executor,
    private val networkPageSize: Int): PagedList.BoundaryCallback<Event>() {

    val helper = PagingRequestHelper(ioExecutor)
    val networkState = helper.createStatusLiveData()




}