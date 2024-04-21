package com.example.weather2.domain

import com.example.weather2.data.WeatherRepository
import com.example.weather2.response.WeatherResponse

class GetWeatherUseCase(private val repository: WeatherRepository) {
    suspend fun execute(location: String, days: Int, aqi: String, alerts: String): WeatherResponse {
        return repository.getWeather(location, days, aqi, alerts)
    }
}