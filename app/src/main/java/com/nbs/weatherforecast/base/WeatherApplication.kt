package com.nbs.mykotlinlearning

import android.app.Application
import com.nbs.weatherforecast.di.AppComponent
import com.nbs.weatherforecast.di.AppModule
import com.nbs.weatherforecast.di.DaggerAppComponent

/**
 * Created by sidiqpermana on 8/9/17.
 */
class WeatherApplication : Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()

    }
}