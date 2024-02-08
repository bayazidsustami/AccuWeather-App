package com.example.weatherapp.domain.model

data class GeoPositionModel(
    val locationKey: String,
    val type: String,
    val postalCode: String,
    val region: String,
    val country: String,
    val cityName: String,
    val locationName: String,
    val timeZone: String,
)