package com.nbs.weatherforecast.view.main.contract

import com.nbs.weatherforecast.base.IBasePresenter

/**
 * Created by sidiqpermana on 8/26/17.
 */
interface IMainPresenter: IBasePresenter<MainView> {
    fun loadForecast()
}