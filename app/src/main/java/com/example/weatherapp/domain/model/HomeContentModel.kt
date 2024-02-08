package com.example.weatherapp.domain.model

data class HomeContentModel(
    val geoPosition: GeoPositionModel,
    val currentWeather: CurrentWeatherModel,
    val hourlyWeather: List<HourlyWeatherModel>,
    val historyWeather: List<HistoryWeatherModel>
)