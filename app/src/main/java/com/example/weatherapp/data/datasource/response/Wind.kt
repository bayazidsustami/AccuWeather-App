package com.example.weatherapp.data.datasource.response

import com.google.gson.annotations.SerializedName

data class Wind(

    @field:SerializedName("Speed")
    val speed: Speed? = null,

    @field:SerializedName("Direction")
    val direction: Direction? = null
) {
    data class Direction(

        @field:SerializedName("English")
        val english: String? = null,

        @field:SerializedName("Degrees")
        val degrees: Int? = null,

        @field:SerializedName("Localized")
        val localized: String? = null
    )
}