package com.nbs.weatherforecast.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by sidiqpermana on 8/9/17.
 */

data class City(val name: String, val country: String)

data class DailyWeatherItem(val dt: Long, val temp: Temp, @SerializedName("weather") val weatherItems: ArrayList<WeatherItem>)

data class WeatherItem(val id: Int, val main: String, val description: String, val icon: String)

data class Temp(val day: Float, val min: Float, val max: Float, val night: Float, val eve: Float, val morn: Float)