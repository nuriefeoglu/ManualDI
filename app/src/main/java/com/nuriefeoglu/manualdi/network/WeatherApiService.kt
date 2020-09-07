package com.nuriefeoglu.manualdi.network

import com.nuriefeoglu.manualdi.model.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {

    @GET("getWeather")
    fun getWeather(
        @Query("data.city")
        city: String?,
        @Query("data.lang")
        language: String?
    ): Call<WeatherResponse>

}