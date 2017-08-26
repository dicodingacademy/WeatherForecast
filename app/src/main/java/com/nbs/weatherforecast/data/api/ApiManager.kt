package com.nbs.weatherforecast.data.api

import com.nbs.weatherforecast.data.mapper.CityWeather
import com.nbs.weatherforecast.data.mapper.ObjectMapper
import com.nbs.weatherforecast.data.model.WeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import rx.Observable
import rx.Observable.create
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by sidiqpermana on 8/9/17.
 */

@Singleton
class ApiManager @Inject constructor(private val weatherApi: WeatherApi){
    fun getWeeklyForecast(city: String): Observable<CityWeather>{
        return create {
            subscriber ->
            weatherApi.getWeeklyForecast(city).enqueue(object :Callback<WeatherResponse>{
                override fun onResponse(call: Call<WeatherResponse>?, response: Response<WeatherResponse>?) {
                    if (response?.isSuccessful as Boolean){
                        subscriber.onNext(ObjectMapper().getCityWeather(response.body()))
                    }else{
                        subscriber.onError(Throwable(response.message()))
                    }
                }

                override fun onFailure(call: Call<WeatherResponse>?, t: Throwable?) {
                    subscriber.onError(Throwable(t))
                }
            })

        }
    }
}