package com.example.weather2.data

import com.example.weather2.response.WeatherResponse

class WeatherRepository(private val api: WeatherApi) {

    suspend fun getWeather(location: String, days: Int, aqi: String, alerts: String): WeatherResponse {
        val key = "8a8b25949fec425599f92306240304"
        return api.getForecast(key, location, days, aqi, alerts)
    }
}