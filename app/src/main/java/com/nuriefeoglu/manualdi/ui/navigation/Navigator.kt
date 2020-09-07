package com.nuriefeoglu.manualdi.ui.navigation

import android.app.Activity
import android.content.Intent
import com.nuriefeoglu.manualdi.ui.activity.WeatherResultActivity

object Navigator {

    fun navigateToWeatherResultActivity(activity: Activity, city: String) {
        val intent = Intent(activity, WeatherResultActivity::class.java)
        intent.putExtra(WeatherResultActivity.CITY_PARAMETER, city)
        activity.startActivity(intent)

    }
}