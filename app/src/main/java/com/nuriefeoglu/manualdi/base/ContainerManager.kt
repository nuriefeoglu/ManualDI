package com.nuriefeoglu.manualdi.base

import com.nuriefeoglu.manualdi.di.appcontainer.AppContainer
import com.nuriefeoglu.manualdi.di.appcontainer.WeatherResultContainer

object ContainerManager {

    private var appContainer: AppContainer = AppContainer()

    fun createWeatherResultContainer(): WeatherResultContainer{
        return WeatherResultContainer(appContainer)
    }


}