package com.example.weatherapp.data.repository

import com.example.weatherapp.common.qualifiers.IODispatcher
import com.example.weatherapp.data.datasource.network.ApiService
import com.example.weatherapp.data.datasource.response.CurrentConditionsResponse
import com.example.weatherapp.data.datasource.response.GeoPositionsResponse
import com.example.weatherapp.data.datasource.response.HourlyWeatherResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    @IODispatcher
    private val dispatcher: CoroutineDispatcher,
): WeatherRepository {

    override fun getGeoPosition(latLon: String): Flow<GeoPositionsResponse> {
        return flow {
            val result = apiService.getGeoPosition(latLon)
            emit(result)
        }.flowOn(dispatcher)
    }

    override fun getCurrentCondition(locationKey: String): Flow<List<CurrentConditionsResponse>> {
        return flow {
            val result = apiService.getCurrentCondition(locationKey)
            emit(result)
        }.flowOn(dispatcher)
    }

    override fun getHourlyWeather(locationKey: String): Flow<List<HourlyWeatherResponse>> {
        return flow {
            val result = apiService.getHourlyData(locationKey)
            emit(result)
        }.flowOn(dispatcher)
    }


}