package com.nuriefeoglu.manualdi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nuriefeoglu.manualdi.data.repository.WeatherResultRepository
import com.nuriefeoglu.manualdi.model.WeatherResponseResult

class WeatherResultViewModelFactory(private val weatherResultRepository: WeatherResultRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return WeatherResultViewModel(weatherResultRepository) as T
    }

}

class WeatherResultViewModel(private val weatherResultRepository: WeatherResultRepository) :
    ViewModel() {
    //viewmodel dinlenebilen objeler barındırır
    val weatherResult = MutableLiveData<List<WeatherResponseResult>>()
    val pageLoading = MutableLiveData<Boolean>()
    val pageError = MutableLiveData<String?>()

    /*init {
        getWeatherResult("istanbul", "tr")
    }*/

    fun getWeatherResult(city: String?, language: String?) {
        pageLoading.value = true
        weatherResultRepository.getCityWeatherResult(city, language) {
            if (!it.isNullOrEmpty()) {
                weatherResult.value = it
                pageError.value = null
            } else {
                pageError.value = "Bir hata oluştu"
            }
            pageLoading.value = false
        }

    }

}