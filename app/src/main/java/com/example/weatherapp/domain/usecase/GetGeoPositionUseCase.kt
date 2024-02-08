package com.example.weatherapp.domain.usecase

import com.example.weatherapp.data.repository.WeatherRepository
import com.example.weatherapp.domain.mapper.WeatherMapper
import com.example.weatherapp.domain.model.GeoPositionModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetGeoPositionUseCase @Inject constructor(
    private val repository: WeatherRepository,
    private val mapper: WeatherMapper,
) {

    operator fun invoke(latLon: String) : Flow<GeoPositionModel>{
        return repository.getGeoPosition(latLon).map { mapper.mapGeoPositionToDomain(it) }
    }
}