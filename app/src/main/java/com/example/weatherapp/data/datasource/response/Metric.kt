package com.example.weatherapp.data.datasource.response

import com.google.gson.annotations.SerializedName

data class Metric(

    @field:SerializedName("UnitType")
    val unitType: Int? = null,

    @field:SerializedName("Value")
    val value: Double? = null,

    @field:SerializedName("Unit")
    val unit: String? = null,

    @field:SerializedName("Phrase")
    val phrase: String? = null
)