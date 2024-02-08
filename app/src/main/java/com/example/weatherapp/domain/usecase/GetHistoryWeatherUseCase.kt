package com.example.weatherapp.domain.usecase

import com.example.weatherapp.data.repository.WeatherRepository
import com.example.weatherapp.domain.mapper.WeatherMapper
import com.example.weatherapp.domain.model.HistoryWeatherModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetHistoryWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository,
    private val mapper: WeatherMapper
) {

    operator fun invoke(locationKey: String, timeZone: String = "UTC") : Flow<List<HistoryWeatherModel>> {
        return repository.getHistoryWeather(locationKey).map { mapper.mapHistoryResponseToDomain(it, timeZone) }
    }
}