package com.example.weatherapp.domain.model

data class HourlyWeatherModel(
    val temperature: ValueUnit<Double, String>,
    val dateTime: String,
    val iconPhrase: String,
    val weatherIcon: Int,
)