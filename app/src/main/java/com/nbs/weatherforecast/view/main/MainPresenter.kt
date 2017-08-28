package com.nbs.weatherforecast.view.main

import com.nbs.weatherforecast.base.WeatherApplication
import com.nbs.weatherforecast.data.api.ApiManager
import com.nbs.weatherforecast.view.main.contract.IMainPresenter
import com.nbs.weatherforecast.view.main.contract.MainView
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription
import javax.inject.Inject

/**
 * Created by sidiqpermana on 8/26/17.
 */
class MainPresenter: IMainPresenter {
    protected var subscriptions = CompositeSubscription()

    @Inject lateinit var apiManager: ApiManager
    private var mainView: MainView? = null


    override fun onAttach(view: MainView) {
        subscriptions = CompositeSubscription()
        WeatherApplication.appComponent.inject(this)
        this.mainView = view
    }

    override fun onDetach() {
        subscriptions.clear()
        mainView = null
    }

    override fun loadForecast() {
        mainView?.showLoading()
        val subscription = apiManager.getWeeklyForecast("Jakarta")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( {
                    t -> mainView?.showForecast(t?.weathers)
                    mainView?.hideLoading()
                }, {
                    t: Throwable? -> mainView?.showError(t?.message.toString())
                    mainView?.hideLoading()
                })
        subscriptions.add(subscription)
    }
}