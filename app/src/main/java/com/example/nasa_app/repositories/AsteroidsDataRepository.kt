package com.example.nasa_app.repositories

import com.example.nasa_app.interfaces.IAsteroidsData
import com.example.nasa_app.model.AsteroidDataResponse
import com.example.nasa_app.service.RetrofitProvider

class AsteroidsDataRepository: IAsteroidsData {

    override suspend fun getAsteroidsData(
        startDate: String,
        endDate: String,
        apiKey: String
    ): AsteroidDataResponse {
        val retrofit = RetrofitProvider.retrofitInstance
            .create(IAsteroidsData::class.java)

        return retrofit.getAsteroidsData(startDate, endDate, apiKey)
    }
}