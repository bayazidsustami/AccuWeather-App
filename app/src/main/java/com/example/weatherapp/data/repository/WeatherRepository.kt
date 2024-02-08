package com.example.weatherapp.data.repository

import com.example.weatherapp.data.datasource.response.CurrentConditionsResponse
import com.example.weatherapp.data.datasource.response.GeoPositionsResponse
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun getGeoPosition(latLon: String): Flow<GeoPositionsResponse>

    fun getCurrentCondition(locationKey: String): Flow<List<CurrentConditionsResponse>>
}