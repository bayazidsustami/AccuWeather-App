package com.example.weatherapp.data.datasource.response

import com.google.gson.annotations.SerializedName

data class Pressure(

    @field:SerializedName("Metric")
    val metric: Metric? = null,

    @field:SerializedName("Imperial")
    val imperial: Imperial? = null
)