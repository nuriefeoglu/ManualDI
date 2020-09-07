package com.nuriefeoglu.manualdi.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.nuriefeoglu.manualdi.R
import com.nuriefeoglu.manualdi.base.ContainerManager
import com.nuriefeoglu.manualdi.ui.adapter.WeatherResultAdapter
import com.nuriefeoglu.manualdi.viewmodel.WeatherResultViewModel
import kotlinx.android.synthetic.main.activity_weather_result.*

class WeatherResultActivity : AppCompatActivity() {

    companion object {
        const val CITY_PARAMETER = "city"
    }

    private var city: String? = null
    private var viewModel: WeatherResultViewModel? = null
    private var container = ContainerManager.createWeatherResultContainer()
    private var weatherResultAdapter: WeatherResultAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_result)

        viewModel = ViewModelProvider(
            this,
            container.weatherResultViewModelFactory
        )[WeatherResultViewModel::class.java]

        observeViewModel()
        weatherResultAdapter = WeatherResultAdapter(viewModel,this)
        rcWeatherResult?.adapter = weatherResultAdapter
        rcWeatherResult?.layoutManager = LinearLayoutManager(this)

        city = intent?.getStringExtra(CITY_PARAMETER)
        viewModel?.getWeatherResult(city,"tr")
    }


    private fun observeViewModel() {
        viewModel?.pageLoading?.observe(this, { loadingState ->
            progressBar?.isVisible = loadingState
        })
        viewModel?.pageError?.observe(this, { pageError ->
            txtError?.isVisible = pageError != null
            txtError?.text = pageError

        })
    }


}