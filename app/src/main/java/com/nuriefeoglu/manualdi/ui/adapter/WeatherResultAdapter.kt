package com.nuriefeoglu.manualdi.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.nuriefeoglu.manualdi.R
import com.nuriefeoglu.manualdi.model.WeatherResponseResult
import com.nuriefeoglu.manualdi.viewmodel.WeatherResultViewModel
import kotlinx.android.synthetic.main.item_weather_result.view.*

class WeatherResultAdapter(
    private val weatherResultViewModel: WeatherResultViewModel?,
    lifecyclerOwner: LifecycleOwner
) :
    RecyclerView.Adapter<WeatherResultAdapter.WeatherResultVH>() {

    private val weatherData = arrayListOf<WeatherResponseResult>()

    init {

        weatherResultViewModel?.weatherResult?.observe(lifecyclerOwner, { data ->
            weatherData.clear()
            data?.let {
                weatherData.addAll(it)
            }
            notifyDataSetChanged()
        })

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherResultVH {
        return WeatherResultVH(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_weather_result, parent, false)
        )

    }

    override fun onBindViewHolder(holder: WeatherResultVH, position: Int) {
        holder.bind(weatherData[position])
    }

    override fun getItemCount() = weatherData.size


    class WeatherResultVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val day = itemView.findViewById<TextView>(R.id.txtDay)
        private val description = itemView.findViewById<TextView>(R.id.txtDesc)
        private val degree = itemView.findViewById<TextView>(R.id.txtDegree)

        fun bind(model: WeatherResponseResult) {

            day?.text = model.day
            description?.text = model.description
            degree?.text = model.degree


        }

    }


}

