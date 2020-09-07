package com.nuriefeoglu.manualdi.di.networkcontainer

import com.nuriefeoglu.manualdi.network.WeatherApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object NetworkContainer {

    var apiService: WeatherApiService? = null

    init {
        apiService = provideWeatherApiService(provideRetrofit(provideOkHttp()))
    }

    private fun provideOkHttp(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()

        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor {
                val request = it.request()
                    .newBuilder()
                    .addHeader(
                        "authorization",
                        "apikey 4Xe6lGctq0Mm3ayjBLPBaB:6ZgiblGHRIaE0gXS5HVbNu"
                    ).build()
                it.proceed(request)
            }
            .addInterceptor(interceptor)
            .build()
    }

    private fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .baseUrl("https://api.collectapi.com/weather/")
            .build()
    }

    private fun provideWeatherApiService(retrofit: Retrofit): WeatherApiService {
        return retrofit.create()
    }

}
