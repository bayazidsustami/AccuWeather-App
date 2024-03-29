package com.example.weatherapp.data.datasource.network

import com.example.weatherapp.data.datasource.response.CurrentConditionsResponse
import com.example.weatherapp.data.datasource.response.GeoPositionsResponse
import com.example.weatherapp.data.datasource.response.HistoryWeatherResponse
import com.example.weatherapp.data.datasource.response.HourlyWeatherResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("currentconditions/v1/{location_key}")
    suspend fun getCurrentCondition(
        @Path("location_key") locationKey: String,
        @Query("details") details: Boolean = true
    ) : List<CurrentConditionsResponse>

    @GET("locations/v1/cities/geoposition/search")
    suspend fun getGeoPosition(
        @Query("q") latLon: String
    ) : GeoPositionsResponse

    @GET("forecasts/v1/hourly/12hour/{location_key}")
    suspend fun getHourlyData(
        @Path("location_key") locationKey: String,
    ) : List<HourlyWeatherResponse>

    @GET("currentconditions/v1/{location_key}/historical/24")
    suspend fun getWeatherHistory(
        @Path("location_key") locationKey: String
    ) :  List<HistoryWeatherResponse>
}