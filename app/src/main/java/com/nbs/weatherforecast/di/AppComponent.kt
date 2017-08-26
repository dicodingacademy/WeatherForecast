package com.nbs.weatherforecast.di

import com.nbs.weatherforecast.view.main.MainActivity
import com.nbs.weatherforecast.view.main.MainPresenter
import dagger.Component
import javax.inject.Singleton

/**
 * Created by sidiqpermana on 8/9/17.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class,
        NetworkModule::class,
        WeatherModule::class))
interface AppComponent{
    fun inject(mainActivity: MainActivity)

    fun inject(mainPresenter: MainPresenter)
}