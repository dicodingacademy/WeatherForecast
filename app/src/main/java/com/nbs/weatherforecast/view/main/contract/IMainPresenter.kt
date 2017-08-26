package com.nbs.weatherforecast.view.main.contract

/**
 * Created by sidiqpermana on 8/26/17.
 */
interface IMainPresenter {
    fun onAttachView()
    fun onDetachView()
    fun loadForecast()
}