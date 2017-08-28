package com.nbs.weatherforecast.base

/**
 * Created by sidiqpermana on 8/28/17.
 */
interface BaseView {
    fun showError(message: String)

    fun showLoading()

    fun hideLoading()
}