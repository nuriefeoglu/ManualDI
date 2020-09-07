package com.nuriefeoglu.manualdi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class IntroViewModel : ViewModel() {


    val buttonState = MutableLiveData<Boolean>().apply { setValue(false) }


    fun controlCity(city: String?) {

        buttonState.value = !city.isNullOrBlank()

    }

}