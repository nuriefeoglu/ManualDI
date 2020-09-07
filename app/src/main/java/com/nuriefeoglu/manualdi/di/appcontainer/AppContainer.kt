package com.nuriefeoglu.manualdi.di.appcontainer

import com.nuriefeoglu.manualdi.data.datasource.remote.WeatherRemoteDataSource
import com.nuriefeoglu.manualdi.data.repository.WeatherResultRepository
import com.nuriefeoglu.manualdi.di.networkcontainer.NetworkContainer
import com.nuriefeoglu.manualdi.network.WeatherApiService
import com.nuriefeoglu.manualdi.viewmodel.WeatherResultViewModelFactory

class AppContainer {

    fun getWeatherApiService(): WeatherApiService? {
        return NetworkContainer.apiService
    }

    val remoteDataSource = WeatherRemoteDataSource(getWeatherApiService())

}

class WeatherResultContainer(private val appContainer: AppContainer) {

    private val weatherResultRepository = WeatherResultRepository(appContainer.remoteDataSource)

    val weatherResultViewModelFactory = WeatherResultViewModelFactory(weatherResultRepository)


}
