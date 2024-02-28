package com.example.nasa_app.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nasa_app.interfaces.IAsteroidsData
import com.example.nasa_app.model.AsteroidDataResponse
import com.example.nasa_app.repositories.AsteroidsDataRepository
import kotlinx.coroutines.launch

class AsteroidsViewModel: ViewModel(), IAsteroidsData {


    private val _asteroidData = MutableLiveData<Int>()
    val asteroidData: LiveData<Int> = _asteroidData
    private var asteroidDataRep: IAsteroidsData = AsteroidsDataRepository()


    fun fetchAsteroidData() {
        viewModelScope.launch {
            try {
                val fetchedData = getAsteroidsData("2015-09-07","2015-09-08","XHTunl7AhqAt4VGOW5dEWP1AseCzGBN1hL5ToSA0")
                _asteroidData.value = fetchedData.elementCount
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