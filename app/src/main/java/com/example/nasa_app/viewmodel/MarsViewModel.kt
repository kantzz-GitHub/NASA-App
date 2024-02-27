package com.example.nasa_app.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nasa_app.model.MarsDataResponse
import com.example.nasa_app.model.RoverPhoto
import com.example.nasa_app.service.APIService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient

class MarsViewModel : ViewModel(), APIService {

    private val _marsData = MutableLiveData<List<RoverPhoto>>()
    val marsData: LiveData<List<RoverPhoto>> = _marsData

    override suspend fun getMarsData(sol: Int, page: Int, apiKey:String): MarsDataResponse {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.nasa.gov/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService::class.java)

        var marsData = retrofit.getMarsData(sol, page,apiKey)
        return  marsData
    }

    fun fetchMarsInfo(sol: Int, page: Int,apiKey: String) {
        viewModelScope.launch {

            try {
                val fetchedMarsData = getMarsData(sol,page,apiKey)
                _marsData.value = fetchedMarsData.photos
            } catch (e: Exception) {
                Log.e("MarsViewModel", "Error fetching Mars data: ${e.message}", e)
            }

        }
    }
}