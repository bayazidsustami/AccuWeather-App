package com.example.weatherapp.domain.model

data class CurrentWeatherModel(
    val time: String,
    val currentTemp: Double,
    val currentTempName: String,
    val weatherIcon: Int,
    val windGust: ValueUnit<Double, String>,
    val humidity: ValueUnit<Int, String>,
    val indoorHumidity: ValueUnit<Int, String>,
    val dewPoint: ValueUnit<Int, String>,
    val pressure: ValueUnit<Int, String>,
    val visibility: ValueUnit<Int, String>,
    val cloudCeiling: ValueUnit<Long, String>
)