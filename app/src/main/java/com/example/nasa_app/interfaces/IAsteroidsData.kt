package com.example.nasa_app.interfaces

import com.example.nasa_app.model.AsteroidDataResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IAsteroidsData {
    @GET("neo/rest/v1/feed")
    suspend fun getAsteroidsData(@Query("start_date") startDate: String, @Query("end_date") endDate : String, @Query("api_key") apiKey: String): AsteroidDataResponse

}