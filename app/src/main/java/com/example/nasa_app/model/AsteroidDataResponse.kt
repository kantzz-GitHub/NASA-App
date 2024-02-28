package com.example.nasa_app.model

import com.google.gson.annotations.SerializedName

data class AsteroidDataResponse(
    @SerializedName("element_count")
    val elementCount: Int,

    @SerializedName("near_earth_objects")
    val nearEarthObjects: String
)
