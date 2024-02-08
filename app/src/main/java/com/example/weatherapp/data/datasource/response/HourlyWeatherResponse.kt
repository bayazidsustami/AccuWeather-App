package com.example.weatherapp.data.datasource.response

import com.google.gson.annotations.SerializedName

data class HourlyWeatherResponse(

	@field:SerializedName("Temperature")
	val temperature: Temperature? = null,

	@field:SerializedName("EpochDateTime")
	val epochDateTime: Int? = null,

	@field:SerializedName("IconPhrase")
	val iconPhrase: String? = null,

	@field:SerializedName("DateTime")
	val dateTime: String? = null,

	@field:SerializedName("WeatherIcon")
	val weatherIcon: Int? = null,
){
	data class Temperature(

		@field:SerializedName("UnitType")
		val unitType: Int? = null,

		@field:SerializedName("Value")
		val value: Double? = null,

		@field:SerializedName("Unit")
		val unit: String? = null
	)
}
