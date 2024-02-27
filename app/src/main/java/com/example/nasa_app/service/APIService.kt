package com.example.nasa_app.service
import com.example.nasa_app.model.MarsDataResponse
import com.example.nasa_app.model.RoverPhoto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {

    @GET("mars-photos/api/v1/rovers/curiosity/photos")
    suspend fun getMarsData(@Query("sol") sol: Int,@Query("page") page : Int, @Query("api_key") apiKey: String): MarsDataResponse



}