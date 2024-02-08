package com.example.weatherapp.data.datasource.response

import com.example.weatherapp.data.datasource.response.Speed
import com.google.gson.annotations.SerializedName

data class WindGust(
    @field:SerializedName("Speed")
    val speed: Speed? = null
)