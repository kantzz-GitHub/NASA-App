package com.example.nasa_app.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nasa_app.interfaces.IAsteroidsData
import com.example.nasa_app.model.AsteroidDataResponse
import com.example.nasa_app.model.NearEarthObject
import com.example.nasa_app.repositories.AsteroidsDataRepository
import kotlinx.coroutines.launch
import java.time.LocalDate

class AsteroidsViewModel: ViewModel(), IAsteroidsData {


    private val _asteroidData = MutableLiveData<Map<String,List<NearEarthObject>>>()
    val asteroidData: LiveData<Map<String,List<NearEarthObject>>> = _asteroidData
    private var asteroidDataRep: IAsteroidsData = AsteroidsDataRepository()


    fun fetchAsteroidData() {
        viewModelScope.launch {
            try {
                val fetchedData = getAsteroidsData(LocalDate.now().toString(),LocalDate.now().toString(),"XHTunl7AhqAt4VGOW5dEWP1AseCzGBN1hL5ToSA0")
                _asteroidData.value = fetchedData.nearEarthObjects
                Log.e("AsteroidView", fetchedData.toString())
            } catch (e: Exception) {
                Log.e("AsteroidViewModel", "Error fetching asteroid data: ${e.message}", e)
            }

        }
    }

    override suspend fun getAsteroidsData(
        startDate: String,
        endDate: String,
        apiKey: String
    ): AsteroidDataResponse {
        return asteroidDataRep.getAsteroidsData(startDate, endDate, apiKey)
    }
}