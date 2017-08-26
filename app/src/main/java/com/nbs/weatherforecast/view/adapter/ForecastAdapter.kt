package com.nbs.mykotlinlearning.http.retrofit.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nbs.weatherforecast.R
import com.nbs.weatherforecast.data.mapper.Weather
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_weather.view.*
import java.text.DecimalFormat
import java.util.*

/**
 * Created by sidiqpermana on 8/9/17.
 */
class ForecastAdapter(val context: Context, var list: ArrayList<Weather>): RecyclerView.Adapter<ForecastAdapter.WeatherViewholder>() {
    override fun onBindViewHolder(holder: WeatherViewholder?, position: Int) {
        holder?.bindData(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): WeatherViewholder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_weather, parent, false)
        return WeatherViewholder(view)
    }

    class WeatherViewholder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bindData(weather: Weather){
            with(weather){
                val tempMinMax = "${formatCelcius(temp.min)}°C to ${formatCelcius(temp.max)}°C"
                itemView.tvTempMinMax.text = tempMinMax
                itemView.tvWeatherName.text = weather.name
                itemView.tvDate.text = weather.dateTime
                Picasso.with(itemView.context).load(icon).into(itemView.imgWeather)
            }
        }

        fun formatCelcius(celcius: Float): String {
            val df = DecimalFormat()
            df.setMaximumFractionDigits(2)
            return df.format(celcius)
        }
    }

}