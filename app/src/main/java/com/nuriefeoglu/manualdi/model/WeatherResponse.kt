package com.nuriefeoglu.manualdi.model

data class WeatherResponse(
    val success: Boolean,
    val city: String,
    val result: List<WeatherResponseResult>
)

data class WeatherResponseResult(
    val date: String,
    val day: String,
    val description: String,
    val degree: String,
    val icon: String
) {

    fun getDegreeText(): String = "Derece: $degree"


}