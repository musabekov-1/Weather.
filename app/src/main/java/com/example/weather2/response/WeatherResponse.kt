package com.example.weather2.response

data class WeatherResponse(
    val location: Location,
    val current: Current,
    val forecast: Forecast
)
