package com.example.nasa_app.model

import com.google.gson.annotations.SerializedName

data class NearEarthObject(
    val id:Int,
    val name:String,
    val estimated_diameter: EstimatedDiameter,
    val is_potentially_hazardous_asteroid: Boolean,
    val close_approach_data: List<CloseApproachData>
)

data class EstimatedDiameter (
    @SerializedName("kilometers" ) var kilometers : Kilometers? = Kilometers(),
)

data class Kilometers (

    @SerializedName("estimated_diameter_min" ) var estimatedDiameterMin : Double? = null,
    @SerializedName("estimated_diameter_max" ) var estimatedDiameterMax : Double? = null

)

data class RelativeVelocity (

    @SerializedName("kilometers_per_second" ) var kilometersPerSecond : String? = null,
    @SerializedName("kilometers_per_hour"   ) var kilometersPerHour   : String? = null,
    @SerializedName("miles_per_hour"        ) var milesPerHour        : String? = null

)

data class MissDistance (

    @SerializedName("astronomical" ) var astronomical : String? = null,
    @SerializedName("lunar"        ) var lunar        : String? = null,
    @SerializedName("kilometers"   ) var kilometers   : String? = null,
    @SerializedName("miles"        ) var miles        : String? = null

)

data class CloseApproachData (

    @SerializedName("close_approach_date"       ) var closeApproachDate      : String?           = null,
    @SerializedName("close_approach_date_full"  ) var closeApproachDateFull  : String?           = null,
    @SerializedName("relative_velocity"         ) var relativeVelocity       : RelativeVelocity? = RelativeVelocity(),
    @SerializedName("miss_distance"             ) var missDistance           : MissDistance?     = MissDistance(),
    @SerializedName("orbiting_body"             ) var orbitingBody           : String?           = null

)