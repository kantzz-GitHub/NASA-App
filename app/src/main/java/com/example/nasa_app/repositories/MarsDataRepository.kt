package com.example.nasa_app.repositories

import com.example.nasa_app.interfaces.IMarsData
import com.example.nasa_app.model.MarsDataResponse
import com.example.nasa_app.service.RetrofitProvider

class MarsDataRepository : IMarsData {

    override suspend fun getMarsData(sol: Int, page: Int, apiKey: String): MarsDataResponse {
        val retrofit = RetrofitProvider.retrofitInstance
            .create(IMarsData::class.java)

        return retrofit.getMarsData(sol, page, apiKey)
    }
}