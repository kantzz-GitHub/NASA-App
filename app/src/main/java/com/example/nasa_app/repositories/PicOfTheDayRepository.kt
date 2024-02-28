package com.example.nasa_app.repositories

import com.example.nasa_app.interfaces.IMarsData
import com.example.nasa_app.interfaces.IPicOfTheDay
import com.example.nasa_app.model.MarsDataResponse
import com.example.nasa_app.model.PicOfTheDayResponse
import com.example.nasa_app.service.RetrofitProvider
import retrofit2.create

class PicOfTheDayRepository: IPicOfTheDay{
    override suspend fun getPicOfTheDay(apiKey: String): PicOfTheDayResponse {
        val retrofit = RetrofitProvider.retrofitInstance
            .create(IPicOfTheDay::class.java)

        return retrofit.getPicOfTheDay(apiKey)
    }
}