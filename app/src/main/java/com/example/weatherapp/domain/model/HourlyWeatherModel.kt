package com.example.weatherapp.domain.model

data class HourlyWeatherModel(
    val temperature: ValueUnit<Double, String>,
    val dateTime: Long,
    val iconPhrase: String,
    val weatherIcon: Int,
) {
    fun getCelsius(): Double {
        return (temperature.value - 32) * 5 / 9
    }
}