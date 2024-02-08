package com.example.weatherapp.data.datasource.response

import com.google.gson.annotations.SerializedName

data class PressureTendency(

    @field:SerializedName("Code")
    val code: String? = null,

    @field:SerializedName("LocalizedText")
    val localizedText: String? = null
)