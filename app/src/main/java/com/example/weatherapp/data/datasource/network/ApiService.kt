package com.example.weatherapp.data.datasource.network

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("currentconditions/v1/{location_key}")
    suspend fun getCurrentCondition(
        @Path("location_key") locationKey: String
    )
}