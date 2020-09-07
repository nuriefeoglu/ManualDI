package com.nuriefeoglu.manualdi.data.datasource.remote

import com.nuriefeoglu.manualdi.model.WeatherResponse
import com.nuriefeoglu.manualdi.network.WeatherApiService
import retrofit2.Call

class WeatherRemoteDataSource(private val weatherApiService: WeatherApiService?) {

    fun getWeatherByCity(city: String?, language: String?): Call<WeatherResponse>? {
        return weatherApiService?.getWeather(city, language)
    }

}