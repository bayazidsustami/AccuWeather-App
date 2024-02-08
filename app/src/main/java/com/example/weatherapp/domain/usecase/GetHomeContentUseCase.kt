package com.example.weatherapp.domain.usecase

import com.example.weatherapp.domain.model.HomeContentModel
import dagger.Lazy
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetHomeContentUseCase @Inject constructor(
    private val currentConditionUseCase: Lazy<GetCurrentConditionUseCase>,
    private val geoPositionUseCase: Lazy<GetGeoPositionUseCase>,
    private val hourlyWeatherUseCase: Lazy<GetHourlyWeatherUseCase>,
    private val historyWeatherUseCase: Lazy<GetHistoryWeatherUseCase>,
) {
    operator fun invoke(latLon: String) : Flow<HomeContentModel> {
       return geoPositionUseCase.get().invoke(latLon).flatMapConcat { geoPosition ->
           combine(
               currentConditionUseCase.get().invoke(geoPosition.locationKey, geoPosition.timeZone),
               hourlyWeatherUseCase.get().invoke(geoPosition.locationKey, geoPosition.timeZone),
               historyWeatherUseCase.get().invoke(geoPosition.locationKey, geoPosition.timeZone)
           ){ currentCondition, hourlyWeather, historyWeather ->
               HomeContentModel(
                   geoPosition = geoPosition,
                   currentWeather = currentCondition,
                   hourlyWeather = hourlyWeather,
                   historyWeather = historyWeather
               )
           }
        }
    }
}