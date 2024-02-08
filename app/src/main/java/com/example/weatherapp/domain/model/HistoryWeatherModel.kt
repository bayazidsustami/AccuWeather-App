package com.example.weatherapp.domain.model

data class HistoryWeatherModel(
    val temperature: ValueUnit<Double, String>,
    val dateTime: String,
    val iconPhrase: String,
    val weatherIcon: Int,
) {
    fun getUrlIcon(): String {
        val icon = String.format("%02d", weatherIcon)
        return "https://developer.accuweather.com/sites/default/files/${icon}-s.png"
    }
}