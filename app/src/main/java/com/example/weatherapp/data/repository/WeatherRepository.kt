package com.example.weatherapp.data.repository

import com.example.weatherapp.data.datasource.response.CurrentConditionsResponse
import com.example.weatherapp.data.datasource.response.GeoPositionsResponse
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    suspend fun getGeoPosition(latLon: String): Flow<GeoPositionsResponse>

    suspend fun getCurrentCondition(locationKey: String): Flow<List<CurrentConditionsResponse>>
}