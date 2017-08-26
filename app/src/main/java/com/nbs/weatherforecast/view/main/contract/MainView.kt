package com.nbs.weatherforecast.view.main.contract

import com.nbs.weatherforecast.data.mapper.Weather

/**
 * Created by sidiqpermana on 8/26/17.
 */
interface MainView {
    fun showForecast(forecastItems: ArrayList<Weather>?)

    fun showError(message: String)

    fun showLoading()

    fun hideLoading()
}