package com.nbs.weatherforecast.data.mapper
/**
 * Created by sidiqpermana on 8/9/17.
 */

data class CityWeather(val name: String, val weathers: ArrayList<Weather>)

data class Weather(val dateTime: String, val name: String, val icon: String, val temp: Temprature)

data class Temprature(val day: Float, val min: Float, val max: Float, val night: Float, val evening: Float, val morning: Float)