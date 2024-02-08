package com.example.weatherapp.data.datasource.response

import com.google.gson.annotations.SerializedName

data class GeoPositionsResponse(

	@field:SerializedName("AdministrativeArea")
	val administrativeArea: AdministrativeArea? = null,

	@field:SerializedName("ParentCity")
	val parentCity: ParentCity? = null,

	@field:SerializedName("LocalizedName")
	val localizedName: String? = null,

	@field:SerializedName("SupplementalAdminAreas")
	val supplementalAdminAreas: List<SupplementalAdminAreasItem> = emptyList(),

	@field:SerializedName("Rank")
	val rank: Int? = null,

	@field:SerializedName("Type")
	val type: String? = null,

	@field:SerializedName("TimeZone")
	val timeZone: TimeZone? = null,

	@field:SerializedName("Version")
	val version: Int? = null,

	@field:SerializedName("PrimaryPostalCode")
	val primaryPostalCode: String? = null,

	@field:SerializedName("Region")
	val region: Region? = null,

	@field:SerializedName("Country")
	val country: Country? = null,

	@field:SerializedName("GeoPosition")
	val geoPosition: GeoPosition? = null,

	@field:SerializedName("Key")
	val key: String? = null,
) {
	data class TimeZone(

		@field:SerializedName("GmtOffset")
		val gmtOffset: Double? = null,

		@field:SerializedName("Code")
		val code: String? = null,

		@field:SerializedName("Name")
		val name: String? = null
	)

	data class SupplementalAdminAreasItem(

		@field:SerializedName("LocalizedName")
		val localizedName: String? = null,

		@field:SerializedName("Level")
		val level: Int? = null,
	)

	data class AdministrativeArea(

		@field:SerializedName("CountryID")
		val countryID: String? = null,

		@field:SerializedName("LocalizedType")
		val localizedType: String? = null,

		@field:SerializedName("LocalizedName")
		val localizedName: String? = null,

		@field:SerializedName("Level")
		val level: Int? = null,

		@field:SerializedName("ID")
		val iD: String? = null,
	)
	data class GeoPosition(

		@field:SerializedName("Latitude")
		val latitude: Double? = null,

		@field:SerializedName("Longitude")
		val longitude: Double? = null
	)

	data class Region(

		@field:SerializedName("LocalizedName")
		val localizedName: String? = null,

		@field:SerializedName("ID")
		val iD: String? = null,
	)

	data class Country(

		@field:SerializedName("LocalizedName")
		val localizedName: String? = null,

		@field:SerializedName("ID")
		val iD: String? = null,
	)

	data class ParentCity(

		@field:SerializedName("LocalizedName")
		val localizedName: String? = null,

		@field:SerializedName("Key")
		val key: String? = null,
	)
}
