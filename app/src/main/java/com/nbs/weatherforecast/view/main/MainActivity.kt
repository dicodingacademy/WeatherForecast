package com.nbs.weatherforecast.view.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.nbs.mykotlinlearning.WeatherApplication
import com.nbs.mykotlinlearning.http.retrofit.view.ForecastAdapter
import com.nbs.weatherforecast.R
import com.nbs.weatherforecast.data.mapper.Weather
import com.nbs.weatherforecast.view.main.contract.MainView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), MainView {
    var presenter: MainPresenter ?=null
    var adapter: ForecastAdapter ?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.apply {
            title = "Forecast"
        }

        WeatherApplication.appComponent.inject(this)

        rvWeatherResult.setHasFixedSize(true)
        rvWeatherResult.layoutManager = LinearLayoutManager(this)
        rvWeatherResult.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        adapter = ForecastAdapter(this, ArrayList())
        rvWeatherResult.adapter = adapter

        presenter = MainPresenter(this)
        presenter?.onAttachView()
        presenter?.loadForecast()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onDetachView()
    }

    override fun showLoading() {
        progresbar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progresbar.visibility = View.GONE
    }

    override fun showForecast(forecastItems: ArrayList<Weather>?) {
        adapter?.list = forecastItems?: throw  Exception("Empty List")
        adapter?.notifyDataSetChanged()
    }

    override fun showError(message: String) {
        toast(message)
    }
}
