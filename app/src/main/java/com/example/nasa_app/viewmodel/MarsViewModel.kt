package com.example.nasa_app.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nasa_app.interfaces.IMarsData
import com.example.nasa_app.model.MarsDataResponse
import com.example.nasa_app.model.RoverPhoto
import com.example.nasa_app.repositories.MarsDataRepository
import kotlinx.coroutines.launch

class MarsViewModel : ViewModel(),IMarsData {

    private val _marsData = MutableLiveData<List<RoverPhoto>>()
    val marsData: LiveData<List<RoverPhoto>> = _marsData
    private var marsDataRep: IMarsData = MarsDataRepository()

    override suspend fun getMarsData(sol: Int, page: Int, apiKey: String): MarsDataResponse {

        return marsDataRep.getMarsData(sol, page, apiKey)
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