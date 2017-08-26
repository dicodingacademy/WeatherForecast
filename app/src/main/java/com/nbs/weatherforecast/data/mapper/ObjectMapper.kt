package com.nbs.weatherforecast.data.mapper

import com.nbs.weatherforecast.data.model.DailyWeatherItem
import com.nbs.weatherforecast.data.model.Temp
import com.nbs.weatherforecast.data.model.WeatherResponse
import java.text.DateFormat
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by sidiqpermana on 8/9/17.
 */
class ObjectMapper{
    fun getCityWeather(response: WeatherResponse?): CityWeather{
        return CityWeather(response?.city?.name!!, getWeathers(response.list))
    }

    fun getWeathers(items: ArrayList<DailyWeatherItem>?): ArrayList<Weather>{
        val weathers = ArrayList<Weather>()

        items?.mapTo(weathers) { it ->
            Weather(convertDate(it.dt), it.weatherItems[0].main,
                    getCompleteIconUrl(it.weatherItems[0].icon), getTemprature(it.temp))
        }

        return weathers
    }

    fun getTemprature(temp: Temp): Temprature{
        return Temprature(getCelcius(temp.day), getCelcius(temp.min), getCelcius(temp.max), getCelcius(temp.night), getCelcius(temp.eve),
                getCelcius(temp.morn))
    }

    fun getCelcius(kelvin: Float): Float{
        return kelvin - 273;
    }

    fun convertDate(dt: Long): String{
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(dt*1000)
    }

    fun getCompleteIconUrl(icon: String): String{
        return "http://openweathermap.org/img/w/$icon.png"
    }
}