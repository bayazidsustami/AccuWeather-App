package com.example.weatherapp.data.datasource.response

import com.google.gson.annotations.SerializedName

data class HistoryWeatherResponse(

	@field:SerializedName("Temperature")
	val temperature: Temperature? = null,

	@field:SerializedName("LocalObservationDateTime")
	val localObservationDateTime: String? = null,

	@field:SerializedName("WeatherText")
	val weatherText: String? = null,

	@field:SerializedName("EpochTime")
	val epochTime: Int? = null,

	@field:SerializedName("WeatherIcon")
	val weatherIcon: Int? = null,
)
