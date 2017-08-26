package com.nbs.weatherforecast.data.api

import com.nbs.weatherforecast.data.model.WeatherResponse
import retrofit2.Call
import javax.inject.Inject

/**
 * Created by sidiqpermana on 8/9/17.
 */
class WeatherRestApi @Inject constructor(private val openWeatherMapApiClient: OpenWeatherMapApiClient): WeatherApi{
    override fun getWeeklyForecast(city: String): Call<WeatherResponse> {
        return openWeatherMapApiClient.getWeeklyForecast(city, "694e890a8ba8a09429fadd5361f4a163")
    }

}