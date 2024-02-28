package com.example.nasa_app.viewmodel


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nasa_app.interfaces.IPicOfTheDay
import com.example.nasa_app.model.PicOfTheDayResponse
import com.example.nasa_app.repositories.PicOfTheDayRepository
import kotlinx.coroutines.launch

class PicOfTheDayViewModel: ViewModel(), IPicOfTheDay {

    private val _pictureData = MutableLiveData<PicOfTheDayResponse>()
    val pictureData: LiveData<PicOfTheDayResponse> = _pictureData
    private var pictureDataRepo: IPicOfTheDay = PicOfTheDayRepository()

    override suspend fun getPicOfTheDay(apiKey: String): com.example.nasa_app.model.PicOfTheDayResponse {
        return pictureDataRepo.getPicOfTheDay(apiKey)
    }

    fun fetchPicture(apiKey: String) {
        viewModelScope.launch {
            try {
                val fetchedPicture = getPicOfTheDay(apiKey)
                val picture = object {
                    val copyright: String = fetchedPicture.copyright
                    val date: String = fetchedPicture.date
                    val title: String = fetchedPicture.title
                    val url: String = fetchedPicture.url
                }
                _pictureData.value = picture as PicOfTheDayResponse
            } catch (e: Exception) {
                Log.e("PicOfTheDayViewModel", "Error fetching PicOfTheDay data: ${e.message}", e)
            }
        }
    }
}
