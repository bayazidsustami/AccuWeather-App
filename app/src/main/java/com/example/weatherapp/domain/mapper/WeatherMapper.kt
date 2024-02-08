package com.example.weatherapp.domain.mapper

import com.example.weatherapp.data.datasource.response.CurrentConditionsResponse
import com.example.weatherapp.data.datasource.response.GeoPositionsResponse
import com.example.weatherapp.domain.model.CurrentWeatherModel
import com.example.weatherapp.domain.model.GeoPositionModel
import com.example.weatherapp.domain.model.ValueUnit
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone
import javax.inject.Inject

class WeatherMapper @Inject constructor() {

    fun mapGeoPositionToDomain(response: GeoPositionsResponse) : GeoPositionModel {
        return GeoPositionModel(
            locationKey = response.key ?: "",
            type = response.type ?: "",
            postalCode = response.primaryPostalCode ?: "",
            region = response.region?.localizedName ?: "",
            country = response.country?.localizedName ?: "",
            cityName = response.parentCity?.localizedName ?: "",
            locationName = response.localizedName ?: "",
            timeZone = response.timeZone?.code ?: ""
        )
    }

    fun mapCurrentConditionToDomain(response: List<CurrentConditionsResponse>, timeZone: String): CurrentWeatherModel {
        val data = response.first()
        return CurrentWeatherModel(
            time = epochTimeToReadableString(data.epochTime?.toLong() ?: 0, timeZone),
            currentTemp = data.temperature?.metric?.value ?: 0.0,
            currentTempName = data.weatherText ?: "",
            weatherIcon = data.weatherIcon ?: 0,
            windGust = ValueUnit(
                value = data.windGust?.speed?.metric?.value ?: 0.0,
                unit = data.windGust?.speed?.metric?.unit ?: "km/h"
            ),
            humidity = ValueUnit(
                value = data.relativeHumidity ?: 0,
                unit = "%"
            ),
            indoorHumidity = ValueUnit(
                value = data.indoorRelativeHumidity ?: 0,
                unit = "%"
            ),
            dewPoint = ValueUnit(
                value = data.dewPoint?.metric?.value?.toInt() ?: 0,
                unit = data.dewPoint?.metric?.unit ?: "C"
            ),
            pressure = ValueUnit(
                value = data.pressure?.metric?.value?.toInt() ?: 0,
                unit = data.pressure?.metric?.unit ?: "mb"
            ),
            visibility = ValueUnit(
                value = data.visibility?.metric?.value?.toInt() ?: 0,
                unit = data.visibility?.metric?.unit ?: "km"
            ),
            cloudCeiling = ValueUnit(
                value = data.ceiling?.metric?.value?.toLong() ?: 0,
                unit = data.ceiling?.metric?.unit ?: "m"
            )
        )
    }

    private fun epochTimeToReadableString(epochTime: Long, timeZone: String): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        sdf.timeZone = TimeZone.getTimeZone(timeZone)
        return sdf.format(Date(epochTime * 1000))
    }
}