package com.nbs.weatherforecast.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by sidiqpermana on 8/9/17.
 */
class WeatherResponse( @SerializedName("city") val city: City?, val cod: Int, @SerializedName("list") val list: ArrayList<DailyWeatherItem>)