package com.example.weatherapp.data.datasource.response

import com.google.gson.annotations.SerializedName

data class CurrentConditionsResponse(

	@field:SerializedName("Wind")
	val wind: Wind? = null,

	@field:SerializedName("Temperature")
	val temperature: Temperature? = null,

	@field:SerializedName("PressureTendency")
	val pressureTendency: PressureTendency? = null,

	@field:SerializedName("ObstructionsToVisibility")
	val obstructionsToVisibility: String? = null,

	@field:SerializedName("Ceiling")
	val ceiling: Ceiling? = null,

	@field:SerializedName("EpochTime")
	val epochTime: Int? = null,

	@field:SerializedName("RealFeelTemperature")
	val realFeelTemperature: RealFeelTemperature? = null,

	@field:SerializedName("RelativeHumidity")
	val relativeHumidity: Int? = null,

	@field:SerializedName("LocalObservationDateTime")
	val localObservationDateTime: String? = null,

	@field:SerializedName("UVIndexText")
	val uVIndexText: String? = null,

	@field:SerializedName("WeatherText")
	val weatherText: String? = null,

	@field:SerializedName("CloudCover")
	val cloudCover: Int? = null,

	@field:SerializedName("WindGust")
	val windGust: WindGust? = null,

	@field:SerializedName("UVIndex")
	val uVIndex: Int? = null,

	@field:SerializedName("WeatherIcon")
	val weatherIcon: Int? = null,

	@field:SerializedName("DewPoint")
	val dewPoint: DewPoint? = null,

	@field:SerializedName("Pressure")
	val pressure: Pressure? = null,

	@field:SerializedName("IsDayTime")
	val isDayTime: Boolean? = null,

	@field:SerializedName("IndoorRelativeHumidity")
	val indoorRelativeHumidity: Int? = null,

	@field:SerializedName("ApparentTemperature")
	val apparentTemperature: ApparentTemperature? = null,

	@field:SerializedName("Visibility")
	val visibility: Visibility? = null,
)
