package com.example.weatherapp.domain.usecase

import com.example.weatherapp.domain.model.HomeContentModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetHomeContentUseCase @Inject constructor(
    private val currentConditionUseCase: GetCurrentConditionUseCase,
    private val geoPositionUseCase: GetGeoPositionUseCase,
) {
    operator fun invoke(latLon: String) : Flow<HomeContentModel> {
       return geoPositionUseCase.invoke(latLon).flatMapConcat { geoPosition ->
            currentConditionUseCase.invoke(
                geoPosition.locationKey,
                geoPosition.timeZone,
            ).map {currentWeather ->
                HomeContentModel(
                    geoPosition = geoPosition,
                    currentWeather = currentWeather
                )
            }
        }
    }
}