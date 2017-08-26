package com.nbs.weatherforecast.data.api

import com.nbs.weatherforecast.data.model.WeatherResponse
import retrofit2.Call

/**
 * Created by sidiqpermana on 8/9/17.
 */
interface WeatherApi{
    fun getWeeklyForecast(city: String): Call<WeatherResponse>
}