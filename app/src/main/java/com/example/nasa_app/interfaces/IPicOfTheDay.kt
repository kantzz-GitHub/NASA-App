package com.example.nasa_app.interfaces

import com.example.nasa_app.model.AsteroidDataResponse
import com.example.nasa_app.model.PicOfTheDayResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IPicOfTheDay {
    @GET("planetary/apod")
    suspend fun getPicOfTheDay(@Query("api_key") apiKey: String): PicOfTheDayResponse
}