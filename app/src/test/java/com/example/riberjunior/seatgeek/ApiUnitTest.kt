package com.example.riberjunior.seatgeek

import com.example.riberjunior.seatgeek.api.SeatGeekApi
import org.junit.Test
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executor
import kotlin.test.assertNotNull

class ApiUnitTest{

    @Test
    fun api() {
        val api = SeatGeekApi.create()
        val ioExecutor: Executor
        api.getEvents(100).enqueue(
            object : Callback<SeatGeekApi.ListingEventResponse>{
                override fun onFailure(call: Call<SeatGeekApi.ListingEventResponse>, t: Throwable) {
                    System.out.println(t.message)
                }

                override fun onResponse(
                    call: Call<SeatGeekApi.ListingEventResponse>,
                    response: Response<SeatGeekApi.ListingEventResponse>
                ) {
                    System.out.println(response.body())
                    assertNotNull(response.body())
                }
            }
        )


    }
}