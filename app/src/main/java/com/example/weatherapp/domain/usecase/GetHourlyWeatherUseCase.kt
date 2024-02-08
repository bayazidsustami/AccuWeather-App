package com.example.weatherapp.domain.usecase

import com.example.weatherapp.data.repository.WeatherRepository
import com.example.weatherapp.domain.mapper.WeatherMapper
import com.example.weatherapp.domain.model.HourlyWeatherModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetHourlyWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository,
    private val mapper: WeatherMapper,
) {

    operator fun invoke(locationKey: String, timeZone: String = "UTC") : Flow<List<HourlyWeatherModel>> {
        return repository.getHourlyWeather(locationKey).map {
            mapper.mapHourlyResponseToDomain(it, timeZone)
        }
    }
}