package com.example.nasa_app.interfaces

import com.example.nasa_app.model.MarsDataResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IMarsData {
    @GET("mars-photos/api/v1/rovers/curiosity/photos")
    suspend fun getMarsData(@Query("sol") sol: Int, @Query("page") page : Int, @Query("api_key") apiKey: String): MarsDataResponse

}