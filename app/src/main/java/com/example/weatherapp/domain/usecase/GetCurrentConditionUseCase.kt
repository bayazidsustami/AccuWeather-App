package com.example.weatherapp.domain.usecase

import com.example.weatherapp.data.repository.WeatherRepository
import com.example.weatherapp.domain.mapper.WeatherMapper
import com.example.weatherapp.domain.model.CurrentWeatherModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetCurrentConditionUseCase @Inject constructor(
    private val repository: WeatherRepository,
    private val mapper: WeatherMapper,
) {

    operator fun invoke(locationKey: String, timeZone: String = "UTC") : Flow<CurrentWeatherModel>{
        return repository.getCurrentCondition(locationKey).map {
            mapper.mapCurrentConditionToDomain(it, timeZone)
        }
    }

}