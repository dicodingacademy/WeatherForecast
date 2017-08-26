package com.nbs.weatherforecast.view.main

import com.nbs.mykotlinlearning.WeatherApplication
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
class MainPresenter(view: MainView) : IMainPresenter {
    protected var subscriptions = CompositeSubscription()

    @Inject lateinit var apiManager: ApiManager
    var view: MainView?= view

    override fun onAttachView() {
        subscriptions = CompositeSubscription()
        WeatherApplication.appComponent.inject(this)
    }

    override fun onDetachView() {
        subscriptions.clear()
    }

    override fun loadForecast() {
        view?.showLoading()
        val subscription = apiManager.getWeeklyForecast("Jakarta")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( {
                    t -> view?.showForecast(t?.weathers)
                    view?.hideLoading()
                }, {
                    t: Throwable? -> view?.showError(t?.message.toString())
                    view?.hideLoading()
                })
        subscriptions.add(subscription)
    }
}