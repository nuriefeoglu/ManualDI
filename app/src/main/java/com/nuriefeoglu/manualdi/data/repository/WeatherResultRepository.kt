package com.nuriefeoglu.manualdi.data.repository

import com.nuriefeoglu.manualdi.data.datasource.remote.WeatherRemoteDataSource
import com.nuriefeoglu.manualdi.model.WeatherResponse
import com.nuriefeoglu.manualdi.model.WeatherResponseResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherResultRepository(private val remoteDataSource: WeatherRemoteDataSource) {

    fun getCityWeatherResult(
        city: String?,
        language: String?,
        callback: (List<WeatherResponseResult>?) -> Unit
    ) {
        remoteDataSource.getWeatherByCity(city, language)?.enqueue(
            object : Callback<WeatherResponse> {
                override fun onResponse(
                    call: Call<WeatherResponse>,
                    response: Response<WeatherResponse>
                ) {
                    callback.invoke(response.body()?.result)
                }

                override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                    callback.invoke(null)
                }

            }
        )
    }

}