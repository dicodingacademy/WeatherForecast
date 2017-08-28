package com.nbs.weatherforecast.view.main.contract

import com.nbs.weatherforecast.base.BaseView
import com.nbs.weatherforecast.data.mapper.Weather
import java.util.*

/**
 * Created by sidiqpermana on 8/26/17.
 */
interface MainView: BaseView {
    fun showForecast(forecastItems: ArrayList<Weather>?)
}